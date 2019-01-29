package ru.ncedu.simpleweb.models;

public class Offering{
    private long productId;
    private long officeId;
    private double offeringPrice;

    public Offering(){
    }


    public Offering(long productId, long officeId, double offeringPrice){
        this.productId = productId;
        this.officeId = officeId;
        this.offeringPrice = offeringPrice;
    }

    public Offering(Offering offering){
        this(offering.getProductId(),offering.getOfficeId(),offering.getOfferingPrice());
    }

    public long getProductId() {
        return productId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public double getOfferingPrice() {
        return offeringPrice;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public void setOfferingPrice(double offeringPrice) {
        this.offeringPrice = offeringPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Offering){
            Offering offering = (Offering) obj;
            return offering.getOfficeId()==officeId && offering.getProductId()==productId;
        }
        return false;
    }
}
