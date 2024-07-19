package generics.classes;

public class GenericClassWithTwoParam<S,U> {
    private S anahtar;//S:tüm NON-PRIMITIVE data tipleri

    private U deger;//tüm NON-PRIMITIVE data tipleri

    //parametreli constructor

    public GenericClassWithTwoParam(S anahtar, U deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }


    //getter-setter


    public S getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(S anahtar) {
        this.anahtar = anahtar;
    }

    public U getDeger() {
        return deger;
    }

    public void setDeger(U deger) {
        this.deger = deger;
    }

}
