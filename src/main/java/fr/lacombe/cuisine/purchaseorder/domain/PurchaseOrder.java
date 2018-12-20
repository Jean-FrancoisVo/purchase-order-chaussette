package fr.lacombe.cuisine.purchaseorder.domain;

import java.util.List;

public class PurchaseOrder {

    List<PurchaseOrderLine> lines;

    public PurchaseOrder(List<PurchaseOrderLine> lines) {
        this.lines = lines;
    }

    public List<PurchaseOrderLine> getLines() {
        return lines;
    }


}
