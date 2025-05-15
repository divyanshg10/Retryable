package io.divyanshg10;

public class Retryable {
    private final int retryCount;
    private final long retryIntervalMs;

    public Retryable(int retryCount, long retryIntervalMs) {
        this.retryCount = retryCount;
        this.retryIntervalMs = retryIntervalMs;
    }

    final public void execute(Runnable runnable) {
        for (int i = 0; i < retryCount; i++) {
            try {
                runnable.run();
                return; // Exit if successful
            } catch (Exception e) {
                System.out.println("Attempt " + (i + 1) + " failed: " + e.getMessage());
                if (i < retryCount - 1) {
                    try {
                        Thread.sleep(retryIntervalMs);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Retry interrupted", ie);
                    }
                }
            }
        }
        throw new RuntimeException("All attempts failed");
    }
}
