// github.com/RodneyShag

package __Intro_Examples;

/* Code from online examples */
public class MyObject {
    public synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".fooQ: ending");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }
    // Further Reading: p.166 in PDF about synchronized STATIC methods
}
