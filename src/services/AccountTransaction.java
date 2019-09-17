package services;

public class AccountTransaction {
    public double withdrawal(double balance, double amount){
        if (amount < 0 || ((balance - amount) < 0))
            return -1;
        else return (balance - amount);
    }
    public double deposit(double balance, double amount){
        if (amount <0) return -1;
        else return (balance + amount);
    }
}
