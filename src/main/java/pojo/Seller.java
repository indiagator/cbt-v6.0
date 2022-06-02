package pojo;

import java.util.List;

public interface Seller {

    public List<ProductOffer> getCatalogue();

    public void addProductOffer(ProductOffer productOffer);

}
