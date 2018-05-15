package com.twu.biblioteca;

public abstract class Item {
    protected int id;
    protected Boolean borrowed;

    Item(int id) {
        this.id = id;
        this.borrowed = false;
    }

    public Boolean isCheckout() {
        return this.borrowed;
    }

    public void checkout() {
        this.borrowed = true;
    }

    public void checkin() {
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }
}
