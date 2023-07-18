package practice.common.threads;

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

    static class MyThreadRunnable implements Runnable {

        public MyThreadRunnable() {
        }

        @Override
        public void run() {
            logic();
        }
    }
}
