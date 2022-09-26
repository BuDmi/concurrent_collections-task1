package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        int specialistsNum = 60;
        int generatedCallsNum = 10;

        BlockingQueue<String> calls = new ArrayBlockingQueue<>(specialistsNum);

        new Atc("ATC", calls, generatedCallsNum).start();
        for (int i = 0; i < specialistsNum; i++) {
            new Specialist("Specialist " + (i + 1), calls).start();
        }
    }
}