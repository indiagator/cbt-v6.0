package pojo;

import java.util.Set;

public class ProductOffer
{
            private String sellerUsername;
            private String hscode;
            private int qty;
            private String window; // immediate(upto 3 months) - projected( from 3 to 12 months)
            private int unitPrice;

            public ProductOffer()
            {

            }

    public String getProduct() {
        return hscode;
    }

    public void setProduct(String hscode) {
        this.hscode = hscode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOfferPrice()
    {
        return this.qty * this.unitPrice;
    }
}
