package practice.threads;

/**
 * This class shows how to create a thread in two different ways:
 * - Extending the Thread class.
 * - Implementing the Runnable interface.
 */
public class ThreadExample {

    public static void main(String[] args) {

        Thread myThread = new Thread(new MyThreadRunnable());
        myThread.start();


        MyThreadExtended extended = new MyThreadExtended("MyThreadExtended");
        extended.start();
    }

    static void logic() {
        int i = 0;
        while(i < 3000) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " = " + i++);
        }
    }

    /**
     * This class extends the Thread class.
     * It's a good practice to override the constructor and call the super constructor.
     * You should override the run() method.
     * Take into account that you can't extend another class.
     */
    static class MyThreadExtended extends Thread {

        public MyThreadExtended() {
        }

        public MyThreadExtended(String name) {
            super(name);
        }

        public void run(){
            logic();
        }
    }

    /**
     * This class implements the Runnable interface.
     * You should override the run() method.
     * Take into account that you can extend another class.
     * You can pass the Runnable object to the Thread constructor.
     */
    static class MyThreadRunnable implements Runnable {

        public MyThreadRunnable() {
        }

        @Override
        public void run() {
            logic();
        }
    }
}
