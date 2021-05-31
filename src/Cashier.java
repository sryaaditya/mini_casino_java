import java.util.Scanner;

/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */
/**
 * Cashier Class
 */
public class Cashier extends Casino {
    public void cashier() {
        try (Scanner keyboard = new Scanner(System.in)) {
            Blackjack blackjack = new Blackjack();
            String repeat = "";
            Account.getSetAccount account = new Account.getSetAccount();
            Transaction transaction = new Transaction();

            do {
                System.out.println("---------------------------------------------");
                System.out.println(" Hi " + account.getName() + ", how can we help you.");
                System.out.println(" Your balance is now : " + account.getBalance());
                System.out.println("---------------------------------------------");
                System.out.println(" 1. Withdraw ");
                System.out.println(" 2. Deposite ");
                System.out.println(" 3. Main menu");
                System.out.println(" etc. To exit");
                System.out.print(" Enter your answer: ");
                int cashierMenu = keyboard.nextInt();

                switch (cashierMenu) {
                    case 1:
                        System.out.print(" How much : $");
                        int withdrawValue = keyboard.nextInt();
                        transaction.withdraw(account.getBalance(), withdrawValue);

                        account.setBalance(transaction.accBalance());

                        System.out.println(" Your balance is now : $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print(" How much : $");
                        int depositeValue = keyboard.nextInt();

                        /**
                         * While player deposite less than $10 it repeat the input and add a warning
                         */
                        while (depositeValue < 10) {
                            System.out.print(" Minimum deposite is $10. How much : $");
                            depositeValue = keyboard.nextInt();
                        }

                        transaction.deposite(account.getBalance(), depositeValue);

                        account.setBalance(transaction.accBalance());
                        System.out.println(" Your balance is now : $" + account.getBalance());
                        break;
                    case 3:
                        blackjack.game();
                        break;
                    default:
                        System.out.println(" See you!");
                        break;
                }
                System.out.println("---------------------------------------------");
                System.out.println(" Anything else we can do for you ? \n[y = Yes, b = Blackjack, etc. To Exit]");
                repeat = keyboard.next();
                if (repeat.equals("b") || repeat.equals("B")) {
                    blackjack.game();
                }
            } while ((repeat.equals("y")) || (repeat.equals("Y")));
        }

    }
}