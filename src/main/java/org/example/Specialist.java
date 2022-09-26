package org.example;

import java.util.concurrent.BlockingQueue;

public class Specialist extends Thread {

    private final BlockingQueue<String> calls;

    public Specialist(String name, BlockingQueue<String> calls) {
        super(name);
        this.calls = calls;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                String processedCall = calls.take();
                int processedTime = 3000;
                Thread.sleep(processedTime);
                System.out.println(Thread.currentThread().getName() + " processed " + processedCall);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
