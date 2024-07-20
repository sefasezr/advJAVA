package generics.interfaces;
//2.SEÇENEK: Generic interfacei implemente ederken data tipine karar verebiliriz
public class GenericInterfaceStringImpl implements GenericInterface <String>{

    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return "";
    }

}
