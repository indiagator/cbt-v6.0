package pojo;

import java.util.LinkedList;
import java.util.List;

public class Prosumer extends Human implements Buyer
{
    List<ProductOffer> productOfferList;

    public Prosumer()
    {
        productOfferList = new LinkedList<>();
    }
    public Prosumer(String username, String password) {
        super(username, password);
    }

    public Prosumer(String username, String phonenumber, String password) {
        super(username, phonenumber, password);
    }

    public Prosumer(String username, String phonenumber, String emailid, String password) {
        super(username, phonenumber, emailid, password);
    }

    @Override
    public List<Order> getOrderList() {

        return null;
    }

    public List<ProductOffer> getCatalogue() {

        return productOfferList;
    }

    public void addProductOffer(ProductOffer productOffer) {

        productOfferList.add(productOffer);

    }
}
