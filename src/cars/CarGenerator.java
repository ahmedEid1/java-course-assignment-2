package cars;

import cars.Constants.CarBrand;
import cars.Constants.CarColor;
import cars.Constants.CarModel;

public class CarGenerator {
    public static Car[] generateRandomCars(int carCount) {
        var cars = new Car[carCount];

        for (int i = 0; i < carCount; i++) {
            cars[i] = getRandomCar();
        }

        return cars;
    }

    private static Car getRandomCar() {
        // random year between 2000 and 2020
        var yearOfManufacture = (int) (Math.random() * 23) + 2000;

        var registerNumber =  String.format("%s_%s_%d",
                CarBrand.getRandomCarBrand(),
                CarModel.getRandomCarModel(),
                (int) (Math.random() * 10000)
        );

        return new Car(
                CarBrand.getRandomCarBrand(),
                CarModel.getRandomCarModel(),
                yearOfManufacture,
                registerNumber,
                CarColor.getRandomCarColor(),
                Math.random() * 100000);
    }
}
