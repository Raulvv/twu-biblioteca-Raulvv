package com.twu.biblioteca;

public abstract class Item {
    protected int id;
    protected Boolean checkoutStatus;

    Item(int id) {
        this.id = id;
        this.checkoutStatus = false;
    }

    public Boolean isCheckout() {
        return this.checkoutStatus;
    }

    public void checkout() {
        this.checkoutStatus = !this.checkoutStatus;
    }

    public int getId() {
        return id;
    }
}
