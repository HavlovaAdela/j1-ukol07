package cz.czechitas.ukol7.controller;

public enum Barva {
    CERVENA("červená"), ZLUTA("žlutá");
    private final String text;

    Barva(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
