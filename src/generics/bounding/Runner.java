package generics.bounding;

public class Runner {
    public static void main(String[] args) {

        Integer[] integers = {2,3,6,9,8,7};
        Double[] doubles = {0.3,99.3,10.0,2.3};
        String[] strings = {"hello","world"};

        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>();
        obj1.numberArray=integers;

        System.out.println(obj1.countAverage());

        //GenericUpperBound<String> obj2 = new GenericUpperBound<String>();
        //burada String veremedik çünkü GenericUpperBound class'ini açarken <T extends Number> olarak kısıtladık

        GenericUpperBound<Double> obj3 = new GenericUpperBound<>();

        //GenericUpperBound<Object> obj4 = new GenericUpperBound<Object>();
        //Object kabul etmedi çünkü Object tüm typeların atası


    }
}
