// github.com/RodneyShag

package _15_3_Dining_Philosophers;

/* Code from online solutions */
public class Philosopher extends Thread {

    /* Data */
    private final int maxPause = 100;
    private int bites = 10;

    private Chopstick left;
    private Chopstick right;
    private int id;

    /* Constructor */
    public Philosopher(int i, Chopstick left, Chopstick right) {
        id = i;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public void eat() {
        System.out.println("Philosopher " + id + ": start eating");
        if (pickUp()) {
            chew();
            putDown();
            System.out.println("Philosopher " + id + ": done eating");
        } else {
            System.out.println("Philosopher " + id + ": gave up on eating");
        }
    }

    public boolean pickUp() {
        pause();
        if (!left.pickUp()) {
            return false;
        }
        pause();
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        pause();
        return true;
    }

    public void chew() {
        System.out.println("Philosopher " + id + ": eating");
        pause();
    }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    /* These functions below help with testing */

    public void pause() {
        try {
            int pause = randomIntInRange(0, maxPause);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
}
