import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huntingtons {

    public static int maxRepeats(String dna) {
        int maxRepeats = 0;
        int currentRepeats = 0;
        for (int i = 0; i <= dna.length() - 3; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                currentRepeats++;
                i += 2;
            } else {
                if (currentRepeats > maxRepeats) {
                    maxRepeats = currentRepeats;
                }
                currentRepeats = 0;
            }
        }
        if (currentRepeats > maxRepeats) {
            maxRepeats = currentRepeats;
        }
        return maxRepeats;
    }

    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s", "");
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) {
            return "not human";
        } else if (maxRepeats >= 10 && maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats >= 36 && maxRepeats <= 39) {
            return "high risk";
        } else if (maxRepeats >= 40 && maxRepeats <= 180) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Huntingtons <filename>");
            return;
        }

        String filename = args[0];
        StringBuilder dna = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                dna.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return;
        }

        String cleanedDna = removeWhitespace(dna.toString());
        int maxRepeats = maxRepeats(cleanedDna);
        String diagnosis = diagnose(maxRepeats);

        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnosis);
    }
}
