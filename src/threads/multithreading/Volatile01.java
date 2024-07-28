package threads.multithreading;

public class Volatile01 {

    /*
        Örneğin 2 thread ortak bir veri üzerinde çalışıyor buna basit şekilde int x = 0 değişkeni diyelim
        threadlerden birisi x'i artırırken öbürü azaltıyor olsun bunu her değiştirdiklerinde ana belleğe tanımlarsa
        problem yok ancak biz multithread ile çalıştığımız için bu threadler işlemcimizin farklı çekirdeklerinde yer alabilir
        CPU1, CPU2 olarak. ve bu çekirdekler threadlerde yapacakları görevi yerine getirmek için ana bellekten x değişkenini almak
        yerine x değişkenini olduğu gibi (x=0) olarak ön belleğine alabilirler böylece bu değişkene erişimi kolay olur
        ancak bu değişkeni artırdıkları zaman veya azalttıkları zaman ana bellekte oluşturulan x değişkenine ortak olarak artırma
        azaltma yapmak yerine iki çekirdek de kendi ön belleğindeki x değişkenine artırma azaltma yapar yani şöyle
        artırma yapan çekirdek x'i 1 yaparken azaltma yapan çekirdek x'i -1 yapar ana bellekteki x değeri ise 0 olarak kalır bu bir risktir
        çünkü veri tutarsızlığı olur bu sorun threadin sorunu değil sorun çekirdeğin cache yani önbellek kullanması
        Biz ortak olan değişken değerinin cache 'e alınmadan ana bellekte kalmasını sağlamalıyız
        Bunu engellemek için(cache alınma durumunu) volatile keywordunu kullanmalıyız volatile keywordu değişkenin cache'e alınmasını
        engeller

         */

    public volatile static int flag = 0;//her çekirdek kendi ön belleğine alırsa bunun önüne geçmek için volatile keyword yazdık
    //volatile: sadece değişkenin değerinin main memory'e yazılmasını ve buradan okunmasını garanti eder

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag<100){
                    System.out.println("Bu sadece bir RİSK!");
                }
            }
        });

        thread1.start(); //CPU 1: flag=0

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(int i = 0; i<100;i++){
                    flag++;
                    System.out.println("Flag değişkeninin değeri değişti: "+flag);
                }

            }
        });

        thread2.start(); //CPU 2:flag=1 CPU 1(thread1)in haberi yok
    }


}
