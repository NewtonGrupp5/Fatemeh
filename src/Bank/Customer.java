/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.ArrayList;

/**
 *
 * @author FF
 */
public class Customer {
    
//    private static SavingsAccount = new SavingsAccount();
   private String customerName;
   private long personalNumber;
   private ArrayList<Account> accounts;
   
   public Customer(String customerName, long personalNumber){
     this.accounts = new ArrayList<Account>();
     this.customerName = customerName;
     this.personalNumber = personalNumber;
   }
   public Customer() {
}
 
public String getCustomerName() {
     return customerName;
   }
    
   public void setCustomerName(String customerName) {
     this.customerName = customerName;
   }
   public int getFirstAccountNr() {
     return accounts.get(0).getAcc_num();
   }
    public int getLastAccountNr() {
     return accounts.get(accounts.size()-1).getAcc_num();
   }
   public ArrayList<Account> getAllAccounts() {
     return accounts;
   }
   public long getPersonalNumber() {
     return personalNumber;
   }
   public void setPersonalNumber(long personalNumber) {
     this.personalNumber = personalNumber;
   }
   public void addAccounts(Account s) {
     accounts.add(s);
   }
   public String getAccountInfo() {
     String info = this.getCustomer() + "\n" ;
     int i = 0;
     while(i<accounts.size()) {
       info += accounts.get(i).getAccount() + "\n";
       i++;
     }
     return info;
   }
    
   public String getCustomer(){
     return "Name: "+customerName+", Personal number: "+ personalNumber;
   }
   // Main method for testing class methods.
//  public static void main(String[] arg) {
//     Customer p = new Customer("Martin", 2525);
//     p.addAccounts(new SavingsAccount("Spar", 2000.0));
//     p.addAccounts(new SavingsAccount("Save", 7000.0));
//     System.out.println(p.getAccountInfo());
//     System.out.println(p.getCustomerName());
//     p.setCustomerName("Sara");
//     System.out.println(p.getCustomerName());
//     p.setPersonalNumber(334455);
//     System.out.println(p.getPersonalNumber());
//     System.out.println(p.getCustomer());
//     p.getAllAccounts();
//    
//   }
//    
 }
