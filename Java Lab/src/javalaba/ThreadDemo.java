package javalaba;

class ThreadDemos implements Runnable {
    private String threadname;

    ThreadDemos(String name){
        threadname = name;
    }
    public void run(){
        for(int i= 0; i< 5; i++) {
            System.out.println(threadname + " - count: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadname + " interrupted Exception");
            }
        }
        System.out.println(threadname + " exiting");
        }
    }
public  class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread( new ThreadDemos("t1"));
        Thread t2 = new Thread( new ThreadDemos("t2"));
        Thread t3 = new Thread( new ThreadDemos("t3"));
        t1.start();
        t2.start();
        t3.start();
    }
}