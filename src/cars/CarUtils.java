package cars;

import cars.Constants.CarBrand;
import cars.Constants.CarModel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.function.Predicate;

public class CarUtils {

    public static Car[] filterByBrand(Car[] cars, CarBrand carBrand) {
        // a) a list of cars of a given brand
        Predicate<Car> brandPredicate = car -> car.getMake().equals(carBrand);

        return Arrays.stream(cars)
                .filter(brandPredicate)
                .toArray(Car[]::new);
    }

    public static Car[] filterByModelAndYearsOfUse(Car[] cars, CarModel carModel, int minYearsOfUse) {
//      b) a list of cars of a given model that have been in use for more than n years;

        // 1- a list of cars of a given brand
        Predicate<Car> modelPredicate = car -> car.getModel().equals(carModel);
        // 2- a list of cars of a given model that have been in use for more than n years
        Predicate<Car> yearsOfUsePredicate = car -> (Year.now().getValue() - car.getYearOfManufacture()) > minYearsOfUse;
        // 1 and 2
        Predicate<Car> modelAndYearsOfUsePredicate = modelPredicate.and(yearsOfUsePredicate);

        return getFilteredCars(cars, modelAndYearsOfUsePredicate);
    }

    public static Car[] filterByYearOfManufactureAndPrice(Car[] cars, int yearOfManufacture, int minPrice) {
//        c) a list of cars of a given year of manufacture, the price of which is higher than the specified one
        // 1. a list of cars of a given year of manufacture
        Predicate<Car> yearOfManufacturePredicate = car -> car.getYearOfManufacture() == yearOfManufacture;
        // 2. a list of cars the price of which is higher than the specified one
        Predicate<Car> pricePredicate = car -> car.getPrice() > minPrice;
        // 1 and 2
        Predicate<Car> yearOfManufactureAndPricePredicate = yearOfManufacturePredicate.and(pricePredicate);

        return getFilteredCars(cars, yearOfManufactureAndPricePredicate);
    }

    private static Car[] getFilteredCars(Car[] cars, Predicate<Car> predicate) {
        return Arrays.stream(cars)
                .filter(predicate)
                .toArray(Car[]::new);
    }

    public static void writeCarsToFile(Car[] bmwCars, String filterCriteria, String[] filterValue) {
        // create the directory if it doesn't exist
        String filterResults = "filter_results";
        var directory = new File(filterResults);
        if (!directory.exists()) {
            directory.mkdir();
        }
        var file = new File(filterResults + "/" + filterCriteria + "_" + Arrays.toString(filterValue) + ".txt");
        try (var fileWriter = new FileWriter(file)) {
          fileWriter.write(Arrays.toString(bmwCars)
                  .replace("}, ", "}\n")
                  .replace(" {", "{")
                  .replace("[", "")
                  .replace("]", "")
                  .replace("cars.Car", "")

          );
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }
}
