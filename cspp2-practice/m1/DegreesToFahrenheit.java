/**
 * @author PriyankaMaladi.
 */
public final class DegreesToFahrenheit {
    /**
     * Empty constructor.
     */
    private DegreesToFahrenheit() {
        // I am not using this constructor.
    }
    /**
     * main function to convert celcius to fahrenheit.
     * @param args is the parameter for this function.
     */
    public static void main(final String[] args) {
        float degree = 31.5f;
        System.out.println("fahrenheit: " + ((degree * 1.8) + 32));
    }
}
