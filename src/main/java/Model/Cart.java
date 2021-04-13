package Model;

public class Cart {
    private int productId;
    private String  account ;
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart() {
    }

    public Cart(int productId, String account, int quantity) {
        this.productId = productId;
        this.account = account;
        this.quantity = quantity;
    }
}
