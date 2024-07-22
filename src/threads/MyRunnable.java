package threads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        //threade yaptırmak istedigimiz islemleri(kodlari)
        System.out.println("Çalışan thread: "+Thread.currentThread().getName());
        System.out.println("MyRunnable ile oluşturulan thread başladı");
    }
}
