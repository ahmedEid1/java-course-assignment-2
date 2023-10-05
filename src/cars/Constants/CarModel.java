package cars.Constants;

public enum CarModel {
    X5,
    X6,
    X7,
    S_CLASS,
    E_CLASS,
    C_CLASS,
    A6,
    A7,
    A8;

    public static CarModel getRandomCarModel() {
        return values()[(int) (Math.random() * values().length)];
    }
}
