package pojo;

import java.util.LinkedList;
import java.util.List;

public class Producer extends Human implements Seller{


    List<ProductOffer> productOfferList;

    public Producer()
    {
        productOfferList = new LinkedList<>();
    }

    public Producer(String username, String password) {
        super(username, password);
    }

    public Producer(String username, String phonenumber, String password) {
        super(username, phonenumber, password);
    }

    public Producer(String username, String phonenumber, String emailid, String password) {
        super(username, phonenumber, emailid, password);
    }

    @Override
    public List<ProductOffer> getCatalogue() {

        return productOfferList;
    }

    public void addProductOffer(ProductOffer productOffer)
    {
        productOfferList.add(productOffer);
    }
}
