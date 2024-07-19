package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};

        System.out.println("--------------printArr ile yazdırma-----------------");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("--------------printArrGeneric ile yazdırma----------------");
        printArrGeneric(intArr);
        printArrGeneric(doubleArr);
        printArrGeneric(stringArr);

        System.out.println("------------------getFirstMetodu kullanımı-------------------");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(stringArr));

        System.out.println("----------------çok parametreli generic metod--------------");
        printArrAndElement(intArr,"AdvJava"); //S:Integer , U:String
        printArrAndElement2(intArr,123); //T:Integer
    }

    //arrayleri yazdırmak icin method tanımlayalım
    //farklı parametreler için : overloading
    public static void printArray(Integer[]arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArray(Double[]arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArray(String[]arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //keşke metodumuz generic olsaydı
    public static <T> void printArrGeneric(T[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }

    //keşke generic return type ı olan bir metod olsa
    public static <T> T getFirst(T[]arr){
        T first = arr[0];
        return first;
    }

    //birden fazla parametreli generic metod
    public static <S,U> void printArrAndElement(S[]arr, U obj){

        //arr[0]=obj; --> farklı data tipleri olabilir.

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);
    }
    public static <T> void printArrAndElement2(T[]arr, T obj){

        arr[0]=obj; // --> ikisinin de data tipi aynı:T

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(obj);
    }

}
