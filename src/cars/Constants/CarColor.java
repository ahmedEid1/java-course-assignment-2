package cars.Constants;

public enum CarColor {
    BLACK,
    WHITE,
    RED,
    BLUE,
    GREEN,
    YELLOW,
    ORANGE,
    PURPLE,
    PINK,
    BROWN,
    GREY;

    public static CarColor getRandomCarColor() {
        return values()[(int) (Math.random() * values().length)];
    }
}
