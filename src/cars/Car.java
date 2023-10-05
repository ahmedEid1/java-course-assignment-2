package cars;

import cars.Constants.CarBrand;
import cars.Constants.CarColor;
import cars.Constants.CarModel;


/*
*  id: auto generated
*  Make, Model, Year of manufacture, Registration number: are final once they are set, as they cannot be changed
*  Color, Price: can change with time, so they are not final and have setters
* */
public class Car {
    private static int idCounter = 0;

    private final int id;
    private final CarBrand make;
    private final CarModel model;
    private final int yearOfManufacture;
    private final String registrationNumber;
    private CarColor color;
    private double price;


    public Car(CarBrand make, CarModel model, int yearOfManufacture, String registrationNumber, CarColor color, double price) {
        this.id = ++idCounter;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public CarBrand getMake() {
        return make;
    }

    public CarModel getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("cars.Car { id: %d, make: %s, model: %s, year: %d, color: %s, price: %.2f, registrationNumber: %s }",
                id, make, model, yearOfManufacture, color, price, registrationNumber);
    }
}
