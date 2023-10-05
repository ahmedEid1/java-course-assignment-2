import cars.Constants.CarBrand;
import cars.Constants.CarModel;
import cars.CarGenerator;
import cars.CarUtils;

public class Main {
    public static void main(String[] args) {
        var cars = CarGenerator.generateRandomCars(50);
        CarUtils.writeCarsToFile(cars, "all", new String[]{});
//        Arrays.stream(cars).forEach(System.out::println);

        var bmwCars = CarUtils.filterByBrand(cars, CarBrand.BMW);
        CarUtils.writeCarsToFile(bmwCars, "brand", new String[]{"BMW"});
//        Arrays.stream(bmwCars).forEach((car) -> System.out.println("bmw car" + car));

        var carsOfModel = CarUtils.filterByModelAndYearsOfUse(cars, CarModel.E_CLASS, 2);
        CarUtils.writeCarsToFile(carsOfModel, "model_and_years_of_use", new String[]{"E_CLASS", "2"});
//        Arrays.stream(carsOfModel).forEach((car) -> System.out.println("cars of model" + car));

        var carsOfManufacture = CarUtils.filterByYearOfManufactureAndPrice(cars, 2015, 10000);
        CarUtils.writeCarsToFile(carsOfManufacture, "year_of_manufacture_and_price", new String[]{"2015", "10000"});
//        Arrays.stream(carsOfManufacture).forEach((car) -> System.out.println("cars of manufacture" + car));
    }
}