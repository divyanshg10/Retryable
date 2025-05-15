package io.divyanshg10;

public class Main {
    public static void main(String[] args) {
        Retryable retryable = new Retryable(3, 1000);

        retryable.execute(() -> {
            // Simulate a task that may fail
            if (Math.random() < 0.7) {
                throw new RuntimeException("Simulated failure");
            }
            System.out.println("Task succeeded");
        });
    }
}