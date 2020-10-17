package models.enums;

public enum ColorForm {

    WHITE("#FFFFFF", 255, 255,255),
    BLACK("#000000", 0,0,0),
    YELLOW("#FFF300", 255, 243, 0),
    BLUE("#00D8FF", 0, 216, 255),
    RED("#F33535", 243, 53,53),
    PURPLE("#B735F3", 183, 53, 243),
    ORANGE("#FF4D00", 255,77,0),
    GREEN("#1CD52D", 28,213,45),
    BEIGE("#D58F1C", 213,143, 28);

    public final String value;
    public final int red;
    public final int green;
    public final int blue;

    ColorForm(String value, int red, int green, int blue) {
        this.value = value;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
