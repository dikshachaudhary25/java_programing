public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]) * Math.PI / 180.0;
        double y1 = Double.parseDouble(args[1]) * Math.PI / 180.0;
        double x2 = Double.parseDouble(args[2]) * Math.PI / 180.0;
        double y2 = Double.parseDouble(args[3]) * Math.PI / 180.0;

        double distance = 6371.0 * 2.0 * Math.asin(Math.sqrt(
            Math.pow(Math.sin((x2 - x1) / 2.0), 2.0) +
            Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2.0), 2.0)
        ));

        System.out.println(distance + " kilometers");
    }
}
