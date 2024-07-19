package generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        //2 farklı ürün: laptop book
        NonGenericProduct laptop = new NonGenericProduct();
        laptop.setCode("ABC123");//code özelliğini String ile set ettik

        NonGenericProduct book = new NonGenericProduct();
        book.setCode(123);//code özelliğini int ile set ettik
        //book.setCode("book123");

        //1-CAST PROBLEMİ!
        //2-ClassCastException problemi!!!
        String str = (String) book.getCode();

        String str2 = (String) laptop.getCode();

        System.out.println(str+str2);
    }
}
