package ru.mrKefir.stty.condition;

/**
 * Defines the condition when MessageWizard should be triggered.
 *
 * @author Mr.Kefir
 */
public interface WizardCondition {
    boolean handle(String buffer);
}
