public class BruteForce {
    private static String password = "r%q";
    private static StringBuilder string;
    private static int min = 32, max = 127;
    private static long start;

    public void loop(int index) {
        for(int i = min; i < max; i++) {
            string.setCharAt(index, (char) i);
            if(index < string.length() - 1)
                loop(index + 1);
            System.out.println(string);
            if(string.toString().equals(password)) {
                System.err.println("password found: " + string);
                System.err.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        BruteForce bruteForce = new BruteForce();
        string = new StringBuilder(password.length());
        for (int i = 0; i < password.length(); i++) {
            string.append((char) min);
        }
        bruteForce.loop(0);
    }

    public static String convertmillis(long input) {
        int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;

        int day = 86400000;
        int hour = 3600000;
        int minute = 60000;
        int second = 1000;


        if(input >= day) {
            days = (int) (input / day);
            millis = (int) (input % day);
        } else
            millis = (int) input;

        if(millis >= hour) {
            hours = millis / hour;
            millis = millis% hour;
        }

        if(millis >= minute) {
            minutes = millis / minute;
            millis = millis % minute;
        }

        if(millis >= second) {
            seconds = millis / second;
            millis = millis % second;
        }

        return (days  + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
    }
}
