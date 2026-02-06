package core_concepts.threads.wait_notify;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        // This is the single shared object both threads will fight for
        MilkBox sharedBox = new MilkBox();

        // Thread 1: The Producer
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBox.deliver();
                // Sleep to simulate time taken to deliver
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        }, "Milkman");

        // Thread 2: The Consumer
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedBox.drink();
                // Sleep to simulate time taken to get thirsty again
                try { Thread.sleep(1500); } catch (InterruptedException e) {}
            }
        }, "Consumer");

        System.out.println("--- Starting Simulation ---");
        producer.start();
        consumer.start();
    }
}
