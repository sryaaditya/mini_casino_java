
/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Balance Class
 */
public class Account extends Cashier {

    /**
     * Static to keep the value even when i do instance object
     */
    private static double balance;
    private static String name;

    public static class getSetAccount {
        public void setBalance(double _balance) {
            balance = _balance;
        }

        public double getBalance() {
            return balance;
        }

        public void setName(String _name) {
            name = _name;
        }

        public String getName() {
            return name;
        }
    }
}
