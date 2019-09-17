package com.company.Platform;

public abstract class Application {
    protected String bank_title;

    public abstract void run(String[] args);

    public String getTitle() {
        return bank_title;
    }

    public void setTitle(String bank_title) {
        this.bank_title = bank_title;
    }
}
