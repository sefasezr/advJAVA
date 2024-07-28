package threads.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Multithreading02 {

    public static int sayac = 0;

    public static void main(String[] args) {

        //taski iki tane threade paylaştıralım: Tom ve Jerry
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i =1;i<6;i++){
                    System.out.println("su satıldı");
                }

                Sayac.increment();//sıralı

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                for(int i =1;i<6;i++){
                    System.out.println("su satıldı");
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i =1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }

                Sayac.increment();//sıralı

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                for(int i =1;i<6;i++){
                    System.out.println("meşrubat satıldı");
                }

            }
        });
        thread1.setName("Tom");
        thread2.setName("Jerry");

        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        /*
        üstte ben öylesine join koydum bilet satış ve öncesinde su satışını görmek ve her işlem bittikten sonra thread2nin
        başladığını gözlemleyip bu sefer de bilet satım öncesi meşrubat satımını gözlemlemek için

        Ancak joinsiz versiyonda da önce tom da jerry de başlayıp su ve meşrubatlarını satacaklar sonrasında senkron olarak
        2000 adet bilet satıcaklar
        sonrasında tekrar su ve meşrubatlarını satıp asenkron şekilde bitiricekler

        Eğer ilk 1000 bileti satanın tekrar meşrubat veya su satmasını engelleyip 2000 bilet satılınca satmaya başlamasını
        istersem kodların önüne bekleme kodu koyarız

         */

        thread2.start();

    }

}

class Sayac {

    //1000 kez sayacın değerini artıracağız

    //bu metoda threadler sırayla erişmeli

    //synchronized: metoda aynı anda sadece 1 tane threadin erişmesine izin verir

    public static void increment(){

        for(int i =1 ; i<1001; i++){

            Multithreading02.sayac++;//1-okuma, 2-artırma, 3-yazdırma

            System.out.println(Thread.currentThread().getName()+ " -------> sayac : "+Multithreading02.sayac);  //2000

        }



    }


}
