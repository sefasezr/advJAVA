package threads.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//threadlerle çalışmak maliyetlidir!!!
//maliyeti azaltmak için thread havuzu oluşturulur
public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {

        //9 tane koli için 9 tane kurye alalım
        ExecutorService service = Executors.newFixedThreadPool(4);  //içinde aktif olan sadece 4 thread var
        //bu işleri sadece 4 thread ile yapacak

        Thread kurye1 = new ThreadCreator("A",10000);
        Thread kurye2 = new ThreadCreator("B",9000);
        Thread kurye3 = new ThreadCreator("C",1000);
        Thread kurye4 = new ThreadCreator("D",3000);
        Thread kurye5 = new ThreadCreator("E",5000);
        Thread kurye6 = new ThreadCreator("F",8000);
        Thread kurye7 = new ThreadCreator("G",2000);
        Thread kurye8 = new ThreadCreator("H",6000);
        Thread kurye9 = new ThreadCreator("K",1000);

    /*    kurye1.start();
        kurye2.start();
        kurye3.start();
        kurye4.start();
        kurye5.start();
        kurye6.start();
        kurye7.start();
        kurye8.start();
        kurye9.start();

     */


        service.execute(kurye1);
        service.execute(kurye2);
        service.execute(kurye3);
        service.execute(kurye4);
        service.execute(kurye5);
        service.execute(kurye6);
        service.execute(kurye7);
        service.execute(kurye8);
        service.execute(kurye9);


        service.shutdown(); //havuzu sonlandırır, aksi halde threadler havuzda beklemeye devam eder.

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



    }
}

class ThreadCreator extends Thread {
    public String task;

    public int duration;//threadlerin calişma süresini belirlemek için

    //param const
    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " işe başladı. Görev : " +this.task);
        System.out.println();
        //bazı kodlar çalışıyormuş gibi bekletelim
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " işini tamamladı.");
        System.out.println();


    }
}
