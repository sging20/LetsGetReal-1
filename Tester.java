public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        double rand = Math.random() * 1000;
        String test = "";

        test = "RealNumber.getValue()";
        try {
            RealNumber num = new RealNumber(rand);
            check(test, num.getValue(), rand);
        } catch(RuntimeException e) {
            except(test, e);
        }
        

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }
}
