package threads.multithreading;
/*
Semaphore, n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar.

Synchronized, aynı anda ortak bir kaynağa(blok,metod) sadece 1 threadin
 erişmesine izin verir.

 semaphore ve synchronized yapılarının birlikte kullanılması, doğru şekilde uygulandığında
 güçlü bir eşzamanlılık kontrolü sağlar, ancak dikkatli ve bilinçli bir şekilde uygulanmalıdır.
*/

import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);//permits yani 4 tane izin kartı verdik

        Car car1 = new Car("Audi",5000,semaphore);
        Car car2 = new Car("Ford",9000,semaphore);
        Car car3 = new Car("Toyota",3000,semaphore);
        Car car4 = new Car("BMW",8000,semaphore);
        Car car5 = new Car("Mercedes",6000,semaphore);
        Car car6 = new Car("Honda",5000,semaphore);
        Car car7 = new Car("Lada",4000,semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();


    }

}



class Car extends Thread{

    public String carName;

    public int duration;

    public Semaphore semaphore;

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName+" park etmek istiyor...");
        try {


            semaphore.acquire();  //acquire: izin vermek demek   //ortak kaynağa erişim iznini kontrol ediyor
            //ortak kaynağın başlangıcı
            System.out.println("---> "+this.carName+" park alanına girdi...");
            Thread.sleep(this.duration);
            System.out.println("<--- "+this.carName+" park alanından ayrılıyor...");
            //ortak kaynağın bitişi
            semaphore.release();//izin belgesi serbest bırakılır, yani kapasite sayısı tekrar artırılmış oluyor
            //release: serbest bırak demek


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

