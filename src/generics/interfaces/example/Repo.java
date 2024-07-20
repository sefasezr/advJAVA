package generics.interfaces.example;

//bu uygulamadaki tüm repoların uyması gereken kurallar var
public interface Repo <T> {

    //save

    void save(T obj);

    //find

    T find();


}
