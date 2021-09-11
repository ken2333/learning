package thread.chapter3;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * describe:
 *
 * @author syh
 * @date 2020/08/15
 */
public class ReentrantRreadWriteTest {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    private static class RunalbleTest implements Runnable {
        private ReentrantReadWriteLock.ReadLock readLock = null;
        private ReentrantReadWriteLock.WriteLock writeLock = null;

        public RunalbleTest(ReentrantReadWriteLock.ReadLock readLock, ReentrantReadWriteLock.WriteLock writeLock) {
            this.readLock = readLock;
            this.writeLock = writeLock;
        }

        @Override
        public void run() {

        }
    }

}
