package generics.bounding;
//generic yapılarda parametre olarak alınan data tipini üstten sınırlandırabiliriz
//T:sadece Number classı VE  alt sınıfları ile sınırlandıralım
//T:BYTE,SHORT,INTEGER,DOUBLE,LONG,FLOAT,NUMBER

public class GenericUpperBound <T extends Number>{
    //BURADA matematiksel hesaplar yapacağımız için T data tipini Number sayi tipleriyle kısıtladık
    //Yani bu T String bir değer alamyacak
    public T[] numberArray;//field

    //numberArray içindeki sayıların ortalamasını bulan bir method
    public Double countAverage(){

        double sum = 0;

        for (T number:this.numberArray){

            sum+=number.doubleValue();//dizi içindeki elemanları double'a çevirip
                                        //toplama ekliyoruz
        }
        double avg = sum/this.numberArray.length;

        return avg;
    }



}
