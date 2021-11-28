package ru.mrKefir.stty.utils;

import java.io.IOException;

public final class Stty {
    public static void disableIcanon() {
        invokeStty("-icanon", "-echo", "min", "1");
    }

    public static void enableIcannon() {
        invokeStty("icanon", "echo");
    }

    public static void restore() {
        invokeStty("sane");
    }

    private static void invokeStty(String... args) {
        try {
            String[] cmd = new String[args.length + 1];
            cmd[0] = "stty";
            System.arraycopy(args, 0, cmd, 1, args.length);
            Process process = new ProcessBuilder()
                    .inheritIO()
                    .command(cmd)
                    .start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
