
/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Main Class
 */
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Blackjack blackjack = new Blackjack();
        Cashier cashier = new Cashier();
        Account.getSetAccount account = new Account.getSetAccount();
        Transaction transaction = new Transaction();

        /**
         * Account Setup
         */
        System.out.println(account.getBalance());
        System.out.println("---------------------------------------------");
        System.out.print(
                " Hi, Welcome to XCasino. \n --------------------------------------------- \n Please enter your name: ");
        String playerName = keyboard.nextLine();
        account.setName(playerName);

        System.out.print(" How much you want to deposite " + playerName + ": ");
        int firstDeposite = keyboard.nextInt();

        transaction.deposite(account.getBalance(), firstDeposite);

        System.out.println("---------------------------------------------");
        System.out.println(" 1. Play Blackjack");
        System.out.println(" 2. Cashier");
        System.out.println(" etc. To Exit");
        System.out.println("---------------------------------------------");
        System.out.print(" Enter your answer: ");
        short mainMenu = keyboard.nextShort();

        switch (mainMenu) {
            case 1:
                blackjack.game();
                break;
            case 2:
                cashier.cashier();
                break;
            default:
                System.out.println("--------------------------------");
                System.out.println(" See you!");
                break;
        }
        keyboard.close();

    }
}
