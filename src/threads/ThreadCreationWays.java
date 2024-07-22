package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        //her java programında default olarak 1 tane thread başlatılır:main thread
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());

        //main threadi bir süre uyutalım
//        try {
//            Thread.sleep(5000);//hangi threadin run metodu içinde yazarsak o thread uyur
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }

        //Thread oluşturmanın ve başlatmanın 2 yolu var:
        //run metodunu override etmeliyiz
        //1.YOL

        Thread thread1 = new MyThread();
        //thread1.run();-->Thread'i başlatmaz sadece run metodunu çağırır aslında herhangi classın metodunu çağırmak gibi
        thread1.start();//Threadi başlatır ve run metodunu çağırır
        thread1.setName("threadcik:)");

        //2.YOL
        Runnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread2.setName("threadman");

        //2.YOL PRATİK: anonymous class : isimsiz sınıf
        //Runnable:functional interface --> sadece run metodu var.
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 3 çalıştı");
                System.out.println("Çalışan thread: "+Thread.currentThread().getName());

            }
        });
        thread3.start();
        thread3.setName("enenenthread");

        //Thread oluşturmak için 2.Yol daha fazla tercih edilebilir sebebi ise 1.Yolda extends Thread class extends edilir
        //ve inheritance yapısında sadece bir adet ebeveyn extends edilebileceği için başka bir extends seçeneğimiz kalmaz
        //Ancak herhangi bir classtan Runnable interface'i implement edildiği zaman interface yapısının çoklu parent özelliği
        //başka şeyleri de implement etme olanağı tanır
        //2 yol arasında tek fark bu eğer fazladan bir parent alacaksak 2. yol almayacaksak 1.yol

        //2.YOL: Runnable:functional interface --> Lambda exp.

        Thread thread4 = new Thread(() -> {
            //run metodunun bodysindeyiz:)
            //threade yaptırmak istediğimiz işlemleri(kodları) yazarız
            System.out.println("thread4 çalıştı");
            System.out.println("Çalışan thread: "+Thread.currentThread().getName());
            System.out.println("Mythread threadi çalışıyor: HARİKA:)");
        });
        //icteki parantezin sebebi run metodudur.

        //main threadi thread4'ü başlatmadan bir süre bekletelim(uyutalım)
//        try {
//            Thread.sleep(3000);//hangi threadin run metodu içinde yazarsak o thread uyur
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }


        thread4.start();
        thread4.setName("threadwoman");

        //System.out.println("main metot burada tamamlandı."); //bu yazı çıktıda sonda glemiyor bunun sebebi threadlerin
        //asenkron çalışmasıdır.
        //bu yazıyı eğer en sonda görmek istersek şunu yapabiliriz
        //main threadi bir süre bekletelim(uyutalım)
        try {
            Thread.sleep(100);//hangi threadin run metodu içinde yazarsak o thread uyur
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("main metot burada tamamlandı");//main threadin görevi bunu yazdırmak

        //Kodlarımızı herhangi bir threadin run metodu içinde yazmazsak main metodun run metodunda yazmış oluruz


        //NOT:her thread kendi işini(run metodu icindeki kodları) senkron (sıralı) çalıştırır
        //Threadler kendi arasında ASENKRON çalışır.



    }






}
