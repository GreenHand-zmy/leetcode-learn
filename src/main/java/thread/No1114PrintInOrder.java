package thread;

import java.util.concurrent.CountDownLatch;

public class No1114PrintInOrder {
    class Foo {
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);

        public Foo() {
            System.out.println();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatchA.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            countDownLatchA.await();
            printSecond.run();
            countDownLatchB.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatchB.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
