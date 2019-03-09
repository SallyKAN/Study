import java.util.Date;

/**
 * @Description
 * @Author kangjiayuan
 * @Date 2019-02-13
 */

public class ThreadStudy {

    public static void main(String[] args) {
        DiningPhilosophers[] diningPhilosophers = new DiningPhilosophers[5];
        Object[] forks = new Object[diningPhilosophers.length];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < diningPhilosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            if (i == diningPhilosophers.length - 1) {
                diningPhilosophers[i] = new DiningPhilosophers(rightFork, leftFork);
            } else {
                diningPhilosophers[i] = new DiningPhilosophers(leftFork, rightFork);
            }
            Thread t
                    = new Thread(diningPhilosophers[i], "Philosopher " + (i + 1));
            t.start();
        }

    }
}



