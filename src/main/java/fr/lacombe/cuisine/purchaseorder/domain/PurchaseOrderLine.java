package fr.lacombe.cuisine.purchaseorder.domain;

public class PurchaseOrderLine {

    private String product;
    private int quantity;

    public PurchaseOrderLine(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseOrderLine that = (PurchaseOrderLine) o;

        if (quantity != that.quantity) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }
}
