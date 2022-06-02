package pojo;

import java.util.List;

public class Consumer extends Human implements Buyer{

    public Consumer(String username, String password) {
        super(username, password);
    }

    public Consumer(String username, String phonenumber, String password) {
        super(username, phonenumber, password);
    }

    public Consumer(String username, String phonenumber, String emailid, String password) {
        super(username, phonenumber, emailid, password);
    }

    @Override
    public List<Order> getOrderList() {

        return null;
    }
}
