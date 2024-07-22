package threads;
//1.YOL: Thread classını extend ederek
public class MyThread extends Thread {

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işlemleri(kodları) yazarız
        System.out.println("Çalışan thread: "+Thread.currentThread().getName());
        System.out.println("Mythread threadi çalışıyor: HARİKA:)");
    }
}
