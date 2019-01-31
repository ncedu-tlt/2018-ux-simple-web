package ru.ncedu.simpleweb.models;

public class OfferingViewModel {

    private long productId;
    private long officeId;
    private String productName;
    private String officeName;
    private Double offeringPrice;

    public OfferingViewModel(){

    }

    public OfferingViewModel(Offering offering, Product product, Office office) {
        this.productId = offering.getProductId();
        this.officeId = offering.getOfficeId();
        this.productName = product.getName();
        this.officeName = office.getName();
        this.offeringPrice = offering.getOfferingPrice();
    }

    public long getProductId() {
        return productId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public String getProductName() {
        return productName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public Double getOfferingPrice() {
        return offeringPrice;
    }
}
