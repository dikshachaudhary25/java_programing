public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            double aSample = (i < a.length) ? a[i] : 0.0;
            double bSample = (i < b.length) ? b[i] : 0.0;
            result[i] = aSample + bSample;
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            int j = (int) (i * alpha);
            result[i] = a[j];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args) {
        // Load WAV files
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");

        // Apply effects
        double[] ampBeatbox = amplify(beatbox, 1.5);
        double[] reverseBuzzer = reverse(buzzer);
        double[] merged = merge(chimes, cow);
        double[] mixed = mix(dialup, buzzer);
        double[] speedCow = changeSpeed(cow, 0.5);

        // Create collage
        double[] collage = merge(merge(ampBeatbox, reverseBuzzer), merge(merged, mix(mixed, speedCow)));

        // Play collage
        StdAudio.play(collage);
    }
}
