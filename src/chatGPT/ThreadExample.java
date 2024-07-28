package chatGPT;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running");
                try {
                    Thread.sleep(1000); // Örnek işlem: 1 saniye bekle
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 is done");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is running");
                System.out.println("Thread 2 is done");
            }
        });

        System.out.println("Starting Thread 1");
        thread1.start();

        try {
            // Thread1'in tamamlanmasını bekle
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Starting Thread 2");
        thread2.start();

        try {
            // Thread2'nin tamamlanmasını bekle
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method is done");

        /*
        Burada joinleri şu amaçla kullandık Starting Thread1 methodu çalıştı ardında Thread1.start(): ile thread1 çalışmaya
        başladı. ancak biz thread2 başlamadan önce thread1.join yazdık bu sebeple main thread thread2yi çalıştırmak için
        thread1in son bulmasını bekledi ve işlemler karışmadı ayrıca main method is done çıktısından önce de thread2.join dedik bu sebeple
        o çıktı da erkenden çıkmamış oldu.

         */
    }
}