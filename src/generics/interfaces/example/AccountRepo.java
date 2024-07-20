package generics.interfaces.example;

//Account için veritabanı işlemleri bu classta yapılacak
public class AccountRepo implements Repo<Account> {
    @Override
    public void save(Account obj) {

    }

    @Override
    public Account find() {
        return null;
    }

    //save(Account obj){}


    //Account find



}
