package thread;

public class No1115PrintFooBarAlternately {


    public static void main(String[] args) {
        Runnable printFoo = () -> System.out.print("Foo");
        Runnable printBar = () -> System.out.print("Bar");


        FooBar fooBar = new FooBar(2);

        new Thread(() -> {
            try {
                fooBar.bar(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class FooBar {
    private int n;

    private int num = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (num == 1) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                num = 2;
            }


//            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (num == 2) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                num = 1;
            }

//            printBar.run();
        }
    }
}
