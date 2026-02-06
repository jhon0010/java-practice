package core_concepts.threads.wait_notify;

public class MilkBox {
    // State: false = empty, true = full
    private boolean hasMilk = false;

    // Method for the Consumer (Drinker)
    public synchronized void drink() {
        // While the box is empty, we must wait
        while (!hasMilk) {
            try {
                System.out.println("😩 Consumer found box empty. Waiting...");
                wait(); // Releases the lock and sleeps
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Critical Section: Modifying the state
        System.out.println("😋 Consumer drank the milk!");
        hasMilk = false;

        // Tell the Producer the box is free now
        notify();
    }

    // Method for the Producer (Milkman)
    public synchronized void deliver() {
        // While the box is full, we must wait
        while (hasMilk) {
            try {
                System.out.println("🛑 Milkman found box full. Waiting...");
                wait(); // Releases the lock and sleeps
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Critical Section: Modifying the state
        System.out.println("🥛 Milkman delivered fresh milk.");
        hasMilk = true;

        // Tell the Consumer there is milk ready
        notify();
    }
}
