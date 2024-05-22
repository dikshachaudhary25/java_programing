public class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    // Constructor
    public Bar(String name, int value, String category) {
        if (name == null || category == null || value < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // CompareTo method for sorting by value
    @Override
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException();
        }
        return Integer.compare(this.value, that.value);
    }

    // Sample client to test Bar class
    public static void main(String[] args) {
        Bar bar1 = new Bar("Beijing", 22674, "East Asia");
        Bar bar2 = new Bar("Cairo", 19850, "Middle East");
        System.out.println(bar1.getName() + " " + bar1.getValue() + " " + bar1.getCategory());
        System.out.println(bar1.compareTo(bar2));
    }
}
