package generics.bounding;

//wildcard(?): Joker, bilinmeyen data tipi
//generic yapıları kullanırken alttan veya üstten sınırlama yapılabilir


import java.util.ArrayList;
import java.util.List;

public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integers=new ArrayList<>();
        List<Double> doubles=new ArrayList<>();
        List<String> strings=new ArrayList<>();
        List<Number> numbers=new ArrayList<>();
        List<Object> objects=new ArrayList<>();

        addElements(integers);
        //addElements(doubles);-->Double integerin parenti değil kardeşi
        addElements(numbers);
        addElements(objects);

        multiplyByTwo(integers);
        multiplyByTwo(doubles);
        multiplyByTwo(numbers);
        //multiplyByTwo(strings);
        //multiplyByTwo(objects); kabul etmedi çünkü Object Number'in atası biz metodu Number ile üstten sınırladık


    }

    //generic yapıyı kullanırken alttan sınırlama
    //listeye 1den 10a kadar tam sayıları ekleyen bir method yazalım
    //list--> ?: Integer, Number, Object
    //aşağıdaki yapıda ? super Integer diyerek ? integerin atasıdır dedik (Integer,Number,Object)
    public static void addElements(List<? super Integer> list){

        for(int i=0;i<list.size();i++){
            list.add(i);
        }

    }

    //generic yapıyı kullanırken üstten sınırlama
    //listedeki elemanları 2 ile çarpan bir metod yazalım
    //list : ?--> : number ve childları
    public static void multiplyByTwo(List<? extends Number> list){
        list.stream().map(t->t.doubleValue()*2);
    }

    //NOT: List<T> ve List<?> benzer yapıdadır fakat kullanımda farkları var!!

    /*
    Java'da List<T> ve List<?> arasındaki farklar aşağıdaki gibidir:

    Tip Güvenliği:

    List<T>: Bu, belirli bir türdeki öğelerden oluşan bir listeyi temsil eder. T, listede saklanabilecek öğelerin türünü belirtir. Örneğin, List<String> sadece String türündeki öğeleri içerebilir.
    List<?>: Bu, belirli olmayan (wildcard) bir türdeki öğelerden oluşan bir listeyi temsil eder. ?, listenin herhangi bir türdeki öğeleri içerebileceğini belirtir, ancak bu tür bilinmez.
    Ekleme İşlemleri:

    List<T>: Bu tür bir listeye öğe eklerken, yalnızca T türündeki öğeler eklenebilir. Örneğin, List<String> listesine sadece String türünde öğeler eklenebilir.
    List<?>: Bu tür bir listeye öğe eklenemez. Çünkü derleyici, listenin hangi türde öğeler içereceğini bilmediği için tür güvenliğini sağlayamaz. Ancak, listeye null eklenebilir.
    Kullanım Senaryoları:

    List<T>: Bu tür, belirli bir türdeki öğelerle çalışırken kullanışlıdır. Tür güvenliği sağlar ve hataların derleme zamanında yakalanmasına yardımcı olur.
    List<?>: Bu tür, herhangi bir türde listeyle çalışırken, türden bağımsız işlemler yaparken kullanışlıdır. Örneğin, bir metodun herhangi bir türde listeyi kabul etmesini istediğinizde List<?> kullanabilirsiniz.
    Okuma İşlemleri:

    List<T>: Bu türde bir listeyi okurken, öğeler T türünde döndürülür. Örneğin, List<String> listesinden döndürülen öğeler String türündedir.
    List<?>: Bu türde bir listeyi okurken, öğeler Object türünde döndürülür. Çünkü derleyici, listenin hangi türde öğeler içereceğini bilmediği için Object döndürür.
    Özetle:

    List<T> belirli bir türdeki öğelerle çalışırken kullanılır ve tür güvenliği sağlar.
    List<?> türden bağımsız işlemler yaparken kullanılır ve herhangi bir türdeki öğelerle çalışabilir, ancak öğe eklenemez.
     */


}
