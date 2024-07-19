package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //2 farklı ürün: laptop , book

        //generic yapılar kullanılırken data tipine karar verilir
        GenericProduct<String> laptop = new GenericProduct<>(); //T:String
        laptop.setCode("ABC123");
        //laptop.setCode(123); Artık data tipi String old. icin laptop objesine String dışında değer atamayız

        GenericProduct<Integer> book = new GenericProduct<>(); //T:Integer
        //book.setCode("ABC123"); book objesine INTEGER tanımladık String koyamayız -->Sıkı bir tür denetimi uygulanır
        book.setCode(123);

        String str = laptop.getCode(); //CAST PROBLEMİ kalmadı
        //String str2 = book.getCode(); CTE alırız ve ClassCastException almaktan kurtardı

        Integer kod = book.getCode();


        //-----------------önceden bildiğimiz generic yapılar*-------------------------

        ArrayList<Boolean> list = new ArrayList<>();
        //list.add(123);
        list.add(true);
        list.add(false);
        list.add(null);

        //K:String V:Integer
        HashMap<String,Integer> map = new HashMap<>();
        map.put("generic",123);

        //------------------------ÇOK PARAMETRELİ GENERIC CLASS--------------------------

        //S:String U:Double
        GenericClassWithTwoParam<String,Double> obj = new GenericClassWithTwoParam<>("Generics",100.0);





    }
}
