public class Clock {
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Hours or minutes out of bounds");
        }
        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (!s.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time format");
        }
        String[] parts = s.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        if (h < 0 || h > 23 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Hours or minutes out of bounds");
        }
        this.hours = h;
        this.minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours || (this.hours == that.hours && this.minutes < that.minutes)) {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (minutes == 59) {
            minutes = 0;
            hours = (hours + 1) % 24;
        } else {
            minutes++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta cannot be negative");
        }
        int totalMinutes = hours * 60 + minutes + delta;
        hours = (totalMinutes / 60) % 24;
        minutes = totalMinutes % 60;
    }

    // Test client
    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59);
        Clock clock2 = new Clock("00:00");

        System.out.println(clock1); // 23:59
        System.out.println(clock2); // 00:00
        System.out.println(clock1.isEarlierThan(clock2)); // false
        clock1.tic();
        System.out.println(clock1); // 00:00
        clock1.toc(60);
        System.out.println(clock1); // 01:00
    }
}
