/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerList; // The list of customers
    public Bank() {
        customerList = new ArrayList<Customer>();
    }
    public ArrayList<String> getAllCustormers() {
        ArrayList<String> customer_data = new ArrayList<String>();
        for (int i = 0; i < customerList.size(); i++) {
            customer_data.add(customerList.get(i).getCustomer());
        }
        return customer_data;
    }
    public boolean createCustomer(String name, long pNo) {
        boolean add = true;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNo) {
                add = false;
            }
        }
        if (add) {
            customerList.add(new Customer(name, pNo));
        }
        return add;
    }
    public ArrayList<String> getCustomer(long pNo) {
        ArrayList<String> intro = new ArrayList<String>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNo) {
                intro.add(customerList.get(i).getCustomer());
                for (int j = 0; j < customerList.get(i).getAllAccounts().size(); j++) {
                    intro.add(customerList.get(i).getAllAccounts().get(j).getAccount());
                }
                return intro;
            }
        }
        return null;
    }
    public boolean changeCustomerName(String name, long pNo) { // CHANGE
                                                                // CUSTORMER
        boolean result = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNo) {
                Customer cust_object = customerList.get(i);
                cust_object.setCustomerName(name);
                customerList.set(i, cust_object);
                result = true;
            }
        }
        return result;
    }
    public ArrayList<String> deleteCustomers(long pNo) {
        ArrayList<String> intro = new ArrayList<String>();
        Customer deletedCustomer = new Customer();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNo) {
                deletedCustomer = customerList.remove(i); // The deleted
                intro.add(deletedCustomer.getCustomer());
                for (Account list : deletedCustomer.getAllAccounts()) {
                    intro.add(list.getAccount());
                }
                return intro;
            }
        }
        return null;
    }
    public int createSavingsAccount(long pNo) { // CREATE SAVINGACCOUNT
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNo) {
                customerList.get(i).addAccounts(new SavingsAccount());
                return customerList.get(i).getLastAccountNr();
            }
        }
        return -1;
    }
    public int addCreditAccount(long pNr) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPersonalNumber() == pNr) {
                customerList.get(i).addAccounts(new CreditAccount());
                return customerList.get(i).getLastAccountNr();
            }
        }
        return -1;
    }
 
    public String getAccount(long pNo, int accountId) { // GET ACCOUNT
        for (Customer client : customerList) {
            if (client.getPersonalNumber() == pNo) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAcc_num() == accountId) {
                        return account.getAccount();
                    }
                }
            }
        }
        return null;
    }
 
    public boolean withdraw(long pNO, int accountId, double amount) {
        for (Customer client : customerList) {
            if (client.getPersonalNumber() == pNO) {
                for (Account account : client.getAllAccounts()) {
                    if (account.getAcc_num() == accountId) {
                        return account.withdraw(amount);
                    }
                }
            }
        }
        return false;
    }
 
    public boolean deposit(long pNr, int accountId, double amount)
    {
        for (Customer person : customerList) {
            if (person.getPersonalNumber() == pNr) {
                for (Account account : person.getAllAccounts()) {
                    if (account.getAcc_num() == accountId) {
                        account.deposit(amount);
                        return true;
                    }
                }
            }
 
        }
        return false;
    }
 
    public String closeAccount(long pNr, int accountId)// CLOSE ACCOUNT
    {
        for (Customer client : customerList) {
            if (client.getPersonalNumber() == pNr)
                for (Account account : client.getAllAccounts()) {
                    if (account.getAcc_num() == accountId) {
                        String data = account.getAccount();
                        account.closeCurrentAccount();
                        client.getAllAccounts().remove(account);
                        System.out.println("");
                        return "Account close" + data;
                    }
                }
        }
        return "Account does not exist ";
    }
 
    public ArrayList<String> getTransactions(long pNr, int accountId) {
        for (Customer client : customerList) {
            if (client.getPersonalNumber() == pNr)
                for (Account account : client.getAllAccounts()) {
                    if (account.getAcc_num() == accountId) {
                        return account.getTransactionsList();
                    }
                }
        }
        return new ArrayList<String>();
    }
 
    public Customer getFirstCustomer() {
        return customerList.get(0);
    }
 
    // Main metod bara for test
    public static void main(String[] arg) {
        Bank p = new Bank();
        p.createCustomer("Anna", 2415L);
        System.out.println(p.addCreditAccount(2415L));
        p.customerList.get(0).getAllAccounts().get(0).withdraw(1000);
 
        Customer anna = p.getFirstCustomer();
        anna.addAccounts(new SavingsAccount("Savings", 3000.0));
        anna.getAllAccounts().get(0).withdraw(1000);
        anna.getAllAccounts().get(0).withdraw(1000);
        anna.addAccounts(new CreditAccount());
        anna.getAllAccounts().get(1).deposit(2000);
        anna.getAllAccounts().get(1).withdraw(1000);
        // anna.getAllAccounts().get(1).withdraw(1000);
        // anna.getAllAccounts().get(1).withdraw(4000);
        // anna.getAllAccounts().get(1).withdraw(2000);
        System.out.println(p.getTransactions(2415L, 1002));
        p.addCreditAccount(2415L);
        anna.getAllAccounts().get(2).withdraw(4000);
        anna.getAllAccounts().get(2).withdraw(2000);
        long personalNumber = Long.valueOf("109414", 10);
        System.out.println(personalNumber);
        System.out.println(p.getTransactions(2415L, 1003));
        p.closeAccount(2415L, 1001);
        p.closeAccount(2415L, 1003);
        p.closeAccount(2415L, 1002);
    }
 
}
