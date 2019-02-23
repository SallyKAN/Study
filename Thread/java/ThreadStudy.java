/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-02-13
 */

public class ThreadStudy extends Thread {
    public void run() {
        try {
            System.out.println("current thread:" + Thread.currentThread().getId() + " is running  "+"priority is: "+Thread.currentThread().getPriority());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        System.out.println("main thread:"+ Thread.currentThread().getPriority());
        for (int i = 0; i < 11; i++) {
            ThreadStudy thread1 = new ThreadStudy();
            thread1.start();
        }
    }
}



