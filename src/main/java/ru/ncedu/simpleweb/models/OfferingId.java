package ru.ncedu.simpleweb.models;


/*
* Просто класс для создания Id у offeringsRepository
* */
public class OfferingId {
     private long officeId;
     private long productId;


    public OfferingId() {
    }

    public OfferingId(long officeId, long productId) {
        this.officeId = officeId;
        this.productId = productId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public long getProductId() {
        return productId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
