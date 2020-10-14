package bca.Hapepedia.dto;

public class ShowcaseDto {
    private long productId;
    private long detailId;
    private String productName;
    private String productVar;
    private String productColor;
    private String productPrice;
    private String productImg;

    public ShowcaseDto() {
    }

    public ShowcaseDto(long productId, long detailId, String productName, String productVar, String productColor,
            String productPrice, String productImg) {
        this.productId = productId;
        this.detailId = detailId;
        this.productName = productName;
        this.productVar = productVar;
        this.productColor = productColor;
        this.productPrice = productPrice;
        this.productImg = productImg;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVar() {
        return productVar;
    }

    public void setProductVar(String productVar) {
        this.productVar = productVar;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

}
