package threads.multithreading;

public class SynchronizedBlock {
    //TASK: Ekrana 14 satırda [ [ [ [ [ ] ] ] ] ]
    //bu taski 2 tane threade yaptıralım

    public static void main(String[] args) {

        Brackets brackets = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 1; i<=7; i++){
                    brackets.printBrackets();
                }
            }
        });
        thread1.setName("Barnie");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i<=7; i++){
                    brackets.printBrackets();
                }
            }
        });
        thread2.setName("Fred");

        thread1.start();

        thread2.start();
    }
}

class Brackets{

    //parantez desenini oluşturan bir metod yazalım
    public /*synchronized*/ void printBrackets(){   //synchronized ekleryerek sorunu çözdük

        //bir thread obje(this) ile bu bloğa eriştiğinde başka thread bu objeyi kullanamasın
        synchronized (this){
            for(int i=1; i<11 ; i++){
                if(i<6){
                    System.out.print("[ ");
                }else {
                    System.out.print("] ");
                }
            }
            System.out.println("------------"+Thread.currentThread().getName());
        }

        //biz yukarıda sadece bloğu senkronize yaptık böyle olunca işlemimiz biraz daha hızlandı eğer metodu senkrionize
        //yapsaydık tüm işlemler sırayla gerçekleşicekti ve işlem daha da uzayacaktı aslında thread'in çok bir önemi kalmamış olacaktı
        //threadlerin hızlı olması sebebi asenkron şekilde birinin işi bittiğinde öbürünün başlamasıyla mümkün oluyordu




        //senkron olması gerekmeyen başka kodlar
        for(int i=1; i<6 ; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
