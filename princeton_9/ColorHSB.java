public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Constructor to create a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("Hue, saturation, or brightness out of bounds");
        }
        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument to distanceSquaredTo() is null");
        }
        int hueDistance = Math.min((hue - that.hue) * (hue - that.hue),
                (360 - Math.abs(hue - that.hue)) * (360 - Math.abs(hue - that.hue)));
        int saturationDistance = (saturation - that.saturation) * (saturation - that.saturation);
        int brightnessDistance = (brightness - that.brightness) * (brightness - that.brightness);
        return hueDistance + saturationDistance + brightnessDistance;
    }

    // Sample client
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inputColor = new ColorHSB(h, s, b);

        String closestColorName = "";
        ColorHSB closestColor = null;
        int minDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();
            ColorHSB predefinedColor = new ColorHSB(hue, saturation, brightness);
            int distance = inputColor.distanceSquaredTo(predefinedColor);
            if (distance < minDistance) {
                minDistance = distance;
                closestColorName = colorName;
                closestColor = predefinedColor;
            }
        }

        System.out.println(closestColorName + " " + closestColor);
    }
}
