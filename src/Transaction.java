
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Vinsensius I Made Surya Aditya
 * 190030097
 */

/**
 * Transaction class
 */

public class Transaction extends Cashier {

    private Account.getSetAccount account = new Account.getSetAccount();
    private double currentBalance;
    private int randomId;

    public void withdraw(double _currentBalance, double withdrawBalance) {
        currentBalance = _currentBalance - withdrawBalance;
        account.setBalance(currentBalance);
        balanceInfo("Withdraw", withdrawBalance);
    }

    public void deposite(double _currentBalance, double depositeBalance) {
        currentBalance = _currentBalance + depositeBalance;
        account.setBalance(currentBalance);
        balanceInfo("Deposite", depositeBalance);
    }

    public double accBalance() {
        return currentBalance;
    }

    public void balanceInfo(String _transactionStatus, double _total) {
        Random random = new Random();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        for (int i = 1; i <= 10; i++) {
            int value = 9999 + random.nextInt(5);
            randomId = value;
        }

        String fileFormat = "=----------------= " + _transactionStatus + " =----------------=\n Transaction Id : "
                + _transactionStatus.substring(0, 2).toUpperCase() + randomId + "\n Date           : "
                + dateTimeFormatter.format(now)
                + "\n\n=----------------=----------=----------------= \n Name           : " + account.getName() + "\n "
                + _transactionStatus + " total : $" + _total + "\n=----------------=----------=----------------=";

        /**
         * Get 3 first letters from the _transaction status
         */
        String fileName = _transactionStatus.substring(0, 3).toUpperCase() + randomId;

        save_file(fileFormat, fileName);
        read_file(fileName);
    }

    public void save_file(String _fileFormat, String _fileName) {
        try {
            FileWriter fileWriter = new FileWriter("src/TransactionNote/" + _fileName + ".txt");
            fileWriter.write(_fileFormat);
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        System.out.println("Success creating note, Please wait...");
    }

    public void read_file(String _fileName) {
        String fileName = "src/TransactionNote/" + _fileName + ".txt";

        try {
            File myFile = new File(fileName);
            Scanner fileReader = new Scanner(myFile);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
