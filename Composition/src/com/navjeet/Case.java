package com.navjeet;

public class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;

    // Composition example
    private Dimension dimensions;

    public Case(String model, String manufacturer, String powerSupply, Dimension dimensions) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;
    }

    public void presPowerButton(){

        System.out.println("Power button pressed");

    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public Dimension getDimensions() {
        return dimensions;
    }
}
