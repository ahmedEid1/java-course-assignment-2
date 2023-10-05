package cars.Constants;

public enum CarBrand {
    BMW,
    MERCEDES,
    AUDI;

    public static CarBrand getRandomCarBrand() {
        return values()[(int) (Math.random() * values().length)];
    }
}
