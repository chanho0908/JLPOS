
package DTO;

public class OrderDTO {
    String productName;
    int productPrice;
    int productCount;
    int totalPrice;
    
    public OrderDTO(){}
    
    public OrderDTO(String productName, int productPrice, int productCount,  int totalPrice){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
