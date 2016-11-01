
package Bank;

public class SavingsAccount  extends Account{
     private boolean  firstWithdrawal=false;
      // konstruktor med parameter 
      public SavingsAccount(String accountType, double balance) { 
//parameter från super class Account
           super (accountType, balance);
            firstWithdrawal=false;
            //EROR kolla här**********************
//          transactionsList.add("Savings account named: " + accountType + " was created: " + date.toString() + " Balance: " + balance);

      }
     
      public SavingsAccount(){

        super();

          }
    public void closeCurrentAccount() {

        System.out.println( "Ending balance: " + balance +  " Interest: " + balance*0.01);

        }

      public boolean withdraw(double value) {
            if(balance >= value){
              if(firstWithdrawal==false){
                balance-=value;
                System.out.println("Cash value out: " + value);
                System.out.println("New balance: " + balance + "\n");
                transactionsList.add("Time: " + date.toString() + " Withdrawal: " + value + " New balance: " + balance);
                firstWithdrawal=true;
                return true;
              }else{
                if (balance>=1.02*value){
                  balance-=1.02*value;
                  System.out.println("Cash value out: " + value);
                  System.out.println("New balance: " + balance + "\n");
                  System.out.println(" some sum of amount money has been debited from your account");
        transactionsList.add("Time: " + date.toString() + " Withdrawal: " + value + " New balance: " + balance);
        return true;
                } else{
                  System.out.println("Not enough balance amount. Deposit some value.\n");
                }
              }
            }else {
              System.out.println("Not enough balance amount. Deposit some value.\n");
              return false;
            }
            return false;
          }

      @Override

        public String toString() {
                      transactionsList.add("Savings account named: " + getAcct_type() + " was created: " + date.toString() + " Balance: " + balance);

            return  super.toString();
        }

       

    // Main metod bara för test

//        public static void main(String[] arg) {
//            SavingsAccount object = new SavingsAccount("savings", 1010);
//            object.withdraw(100);
//            object.withdraw(100);
//            object.withdraw(100);
//            object.deposit(5000);
//            System.out.println(object.transactionsList.toString());
//
//            }

              

     }

