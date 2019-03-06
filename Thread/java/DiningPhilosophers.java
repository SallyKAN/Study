/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-03-05
 */

public class DiningPhilosophers implements Runnable {
    private Object leftfork;
    private Object rightfork;

    public DiningPhilosophers(Object leftfork, Object rightfork) {
        this.leftfork = leftfork;
        this.rightfork = rightfork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 10)));
    }

    @Override
    public void run() {
        try {
                doAction(System.currentTimeMillis() + ": Thinking");
                synchronized (leftfork) {
                    doAction(System.currentTimeMillis() + ": Picked up left fork");
                    synchronized (rightfork) {
                        doAction(System.currentTimeMillis() + ": Picked up right fork - eating");
                        doAction(System.currentTimeMillis() + ": Put down right fork");
                    }
                    doAction(System.currentTimeMillis() + ": Put down left fork. Back to thinking");
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
