package ru.mrKefir.stty.joker;

import ru.mrKefir.stty.condition.WizardCondition;
import ru.mrKefir.stty.reader.TrickyReader;
import ru.mrKefir.stty.utils.Delay;
import ru.mrKefir.stty.utils.ExitCondition;
import ru.mrKefir.stty.utils.Stty;
import ru.mrKefir.stty.wizard.BufferWizard;
import ru.mrKefir.stty.writer.InteractiveWriter;

import java.util.ArrayList;
import java.util.Collection;

public final class Joker {
    private final Collection<WizardCondition> wizardConditions;
    private final BufferWizard bufferWizard;


    public Joker(BufferWizard bufferWizard) {
        wizardConditions = new ArrayList<>();
        this.bufferWizard = bufferWizard;
    }


    public Joker add(WizardCondition wizardCondition) {
        wizardConditions.add(wizardCondition);
        return this;
    }

    public void start() {
        Stty.disableIcanon();

        TrickyReader trickyReader = new TrickyReader();
        InteractiveWriter interactiveWriter = new InteractiveWriter();

        while (true) {
            trickyReader.read();
            while (!matchAnyCondition(trickyReader.getCurrentLine())) {
                if (trickyReader.isLastBackspace()) {
                    trickyReader.drop(2);
                } else {
                    trickyReader.read();
                }
                interactiveWriter.writeImmediately(trickyReader.getCurrentLine());
            }

            String message = getMessage(trickyReader);

            if (ExitCondition.match(message)) {
                interactiveWriter.writeln();
                break;
            }

            Delay.delay(500);

            interactiveWriter.write(bufferWizard.transform(message));

            Delay.delay(2000);

            interactiveWriter.clearLine();
        }

        Stty.restore();
    }

    private String getMessage(TrickyReader trickyReader) {
        String message = trickyReader.getCurrentLine();
        trickyReader.clearBuffer();

        return message;
    }

    private boolean matchAnyCondition(String message) {
        for (WizardCondition wizardCondition : wizardConditions) {
            if (wizardCondition.handle(message)) {
                return true;
            }
        }

        return false;
    }
}
