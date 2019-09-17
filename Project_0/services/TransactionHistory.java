package services;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TransactionHistory {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime transactionTime = LocalDateTime.now();
    private String[] transactionHist_copy = new String[1];
    //to print: dtf.format(now)
    public String[] setTranHist(double balance, double amount, String transType, String[] transactionHist){
        if (transactionHist[0] == null){
            transactionHist_copy = Arrays.copyOf(transactionHist, transactionHist.length);
            transactionHist_copy[0] = "[Transaction type: " + transType + "\nDate: "
                    + dtf.format(transactionTime) + "\nBalance: $"
                    + balance + "\n" + transType + " Amount: $" + amount +"]";
            return transactionHist_copy;
        }
        else if (transactionHist[0] != null){
            transactionHist_copy = Arrays.copyOf(transactionHist, transactionHist.length+1);
            transactionHist_copy[transactionHist_copy.length-1] = "[Transaction type: " + transType + "\nDate: "
                    + dtf.format(transactionTime) + "\nBalance: $"
                    + balance + "\n" + transType + " Amount: $" + amount + "]";
            return (transactionHist_copy);
        }
        return null;
    }

}
