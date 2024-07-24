package threads.multithreading;

//wait-notify : thread arasında iletişimi sağlar.
//üretici(producer)-tüketici(consumer)
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//multi threading uygulamalarda bir threadin işini sürdürebilmesi için
//diğer bir threadin çalışması gerekiyorsa wait/notify veya wait/interrupt ile
//iletişim sağlanabilir



public class WaitInterrupt {

    //NOT!!!!!!: wait(), notify() metodları threadlerin haberleşmesini sağlıyor ancak ortak kaynakta threadlerin haberleşmesini sağlıyor
    // ayrıca methodların senkronize olması gerekiyor objeyi monitör etmemiz gerekiyor yoksa hata alırız

    public static int balance=0;

    //para yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor");
        balance +=amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye: "+balance);

    }
    //para cekme işlemi
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");

        //bakiye yetersiz ise
        if(balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye: "+balance);
            //işleme devam edilemez, bekleyecek
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//monitör edilen objeyi geçici olarak serbest bırakır
            } catch (InterruptedException e) {
                System.out.println("Bakiye güncellendi,işleme devam ediliyor..");
            }

        }
        //kaldığı yerden işleme devam eder
        //bakiye güncellendi
        //bakiye yeterli ise
        if(balance>=amount){
            balance -= amount;
            System.out.println("Para çekme işlemi başarılı, mevcut bakiye: "+balance);
        }else{
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye: "+balance);
            System.out.println("Umudunu kaybetme, yarın gel:)");
        }
    }

    public static void main(String[] args) {
        WaitInterrupt obj = new WaitInterrupt();

        //para çekme ve yatırma işlemlerini 2 tane threade yaptıralım
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                obj.withdraw(1000);
            }
        });
        thread1.setName("Ali Can");
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
                obj.deposit(2000);
               thread1.interrupt();//wait-sleep-join ile beklemekte olan threadi kesintiye uğratır
            }
        });
        thread2.setName("Veli");
        thread2.start();


    }

    
}
