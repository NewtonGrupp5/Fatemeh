/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

/**
 *
 * @author FF
 */
public class CreditAccount extends Account {

    private int creditLimit = 5000;;

    public CreditAccount() {

        super("Credit account", 0);

        transactionsList.add("Credit account named was created: " + date.toString() + " Balance: " + balance);
    }
    public CreditAccount(String accountType, double balance) {

        super(accountType, balance);
    }
    public void closeCurrentAccount() {
        if (balance < 0) {
            System.out.println("Ending balance: " + balance + "Debt/skuld: " + balance * 1.07);
        } else {
            System.out.println("Ending balance: " + balance + "You have interest: " + balance * 0.005);
 
        }
    }
 
    public boolean withdraw(double amount) {
        double total = balance + creditLimit;
        System.out.println(total);
        if (total <= amount) {
            System.out.println("sorry......amount choose is lower amout");
 
            return false;
        } else {
            balance -= amount;
            System.out.println(balance);
            transactionsList.add("Time: " + date.toString() + " Withdrawal: " + amount + " New balance: " + balance);
            return true;
        }
    }
 
    // Main metod är bara för test
 
//    public static void main(String[] arg) {
// 
//        CreditAccount withdrawObj = new CreditAccount();
//        withdrawObj.withdraw(500);
//        withdrawObj.withdraw(4000);
//        withdrawObj.withdraw(501);
//        withdrawObj.withdraw(500);
//        withdrawObj.deposit(1000);
//        withdrawObj.withdraw(100);
//        withdrawObj.withdraw(890);
//        withdrawObj.withdraw(100);
//        System.out.println(withdrawObj.transactionsList.toString());
// 
//    }
}
