package generics.interfaces.example;

//Customer için veritabanı işlemleri bu classta yapılacak
public class CustomerRepo implements Repo<Customer>{
    @Override
    public void save(Customer obj) {

    }

    @Override
    public Customer find() {
        return null;
    }

    //save(Customer obj){
    // insert into ...
    // }

    //Customer find

}
