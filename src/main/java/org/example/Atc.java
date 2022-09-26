package org.example;

import java.util.concurrent.BlockingQueue;

public class Atc extends Thread {

    private final BlockingQueue<String> calls;
    private final int generatedCallsNum;
    private int callNum = 0;

    public Atc(String name, BlockingQueue<String> calls, int generatedCallsNum) {
        super(name);
        this.calls = calls;
        this.generatedCallsNum = generatedCallsNum;
    }

    private void generateCalls() {
        for (int i = 0; i < generatedCallsNum; i++) {
            try {
                calls.put("Call " + (i + 1 + callNum));
                callNum++;
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                generateCalls();
                System.out.println("Generated " + generatedCallsNum + " calls. Total calls " + calls.size());
                int generatedTime = 1000;
                Thread.sleep(generatedTime);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
