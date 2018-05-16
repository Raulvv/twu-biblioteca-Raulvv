package com.twu.biblioteca;

public abstract class Item {
    protected int id;
    protected Boolean borrowed;
    protected String temporalOwner;

    Item(int id) {
        this.id = id;
        this.borrowed = false;
    }

    public Boolean isCheckout() {
        return this.borrowed;
    }

    public void checkout(String code) {
        this.borrowed = true;
        this.temporalOwner = code;
    }

    public void checkin() {
        this.borrowed = false;
        this.temporalOwner = null;
    }

    public int getId() {
        return id;
    }

    public String getTemporalOwner() {
        return this.temporalOwner;
    }

    public abstract String statusToString();
}
