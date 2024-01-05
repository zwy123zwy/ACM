package thread;

import java.util.concurrent.atomic.AtomicInteger;
//  两个线程交替打印
public class thread {

        public static void main(String[] args) throws Exception {
            thread solution = new thread();
            Thread t1 = new Thread(solution::printCharsByVolatile);
            Thread t2 = new Thread(solution::printNumsByVolatile);
            t1.start();
            t2.start();
        }
        volatile boolean flag = true;
        public void printCharsByVolatile() {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < str.length(); i++) {
                while (!flag){}
                System.out.print(str.charAt(i));
                flag = false;
            }
        }
        public void printNumsByVolatile() {
            for (int i = 0; i < 26; i++) {
                while (flag) {}
                System.out.print(i+1);
                flag = true;
            }
        }
    public synchronized void printCharsByWaitNotify(){
        try{
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                this.notify();//通知唤醒线程，但还没释放锁
                this.wait();//释放锁
            }
        }catch (Exception e){e.printStackTrace();}
    }
    public synchronized void printNumsByWaitNotify(){
        try{
            for (int i = 0; i < 26; i++) {
                System.out.print(i+1);
                this.notify();//通知唤醒线程，但还没释放锁
                this.wait();//释放锁
            }
        }catch (Exception e){e.printStackTrace();}
    }
    AtomicInteger flag1 = new AtomicInteger(1);  //使用java提供的CAS锁实现
    public void printCharsByCAS() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < str.length(); i++) {
            while (flag1.get()!=1){}
            System.out.print(str.charAt(i));
            flag1.set(0);
        }
    }
    public void printNumsByCAS() {
        for (int i = 0; i < 26; i++) {
            while (flag1.get()==1) {}
            System.out.print(i+1);
            flag1.set(1);
        }
    }

}
