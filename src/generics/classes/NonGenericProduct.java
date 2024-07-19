package generics.classes;
//amacımız: farklı data tipindeki urun kodlarını tutabilmek icin
//ayrı ayrı classlar oluşturmadan (book, phone, laptop....)
//tek bir class ile urun objelerini oluşturmak

public class NonGenericProduct {

    private Object code;
    //code fieldinin data tipi object oldugu icin
    // olusturulan nesnelerin code ozelliginde tum data tipleri kullanilabilir

    //getter-setter

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

}
