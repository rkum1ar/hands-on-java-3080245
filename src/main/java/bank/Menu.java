package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Menu {
  private Scanner scanner;
  
  public static void main (String [] args)
  {
    System.out.println("Welcome to Globe Bank International");
  Menu menu = new Menu();
  menu.scanner=new Scanner(System.in);
  Customer customer =menu.authenticateUser() ;
if (customer != null){
  Account account=DataSource.getAccount(customer.getAccountID());
 menu.showMenu(customer,account);
}


menu.scanner.close();
  }

  private Customer authenticateUser()
  {
    System.out.print("Please Enter your Username : ");
    String username = scanner.next();
    System.out.println();

    System.out.print("Please Enter your Password : ");
    String password = scanner.next();

    Customer customer = null;
    try{
    customer = Authenticator.login(username, password);
    } catch (LoginException e)
    {
      System.out.println("There was an error: " + e.getMessage());
    }
    return customer;
  }
  private void showMenu(Customer cusotmer, Account account)
  {
  int selection =0;
    while(selection != 4 && cusotmer.isAuthenticated()){
      System.out.println("===================");
      System.out.println("Please select one of the following options: ");
      System.out.println("1 : Deposit");
      System.out.println("2 : Withdrawal");
      System.out.println("3 : Check Balance");
      System.out.println("1 : Exit");
      System.out.println("====================");

      selection=scanner.nextInt();
      double amount = 0;
      switch(selection){
        case 1:
        System.out.println("How much would you like to deposite");
        amount = scanner.nextDouble();
        account.deposit(amount);
        break;

        case 2:
        System.out.println("How much would you like withdraw ? ");
        amount = scanner.nextDouble();
        account.withdraw(amount);
        break;

        case 3:
        System.out.println("Current Balance: " + account.getBalance());
        break;

        case 4:
        Authenticator.logout(cusotmer);
        System.out.println("Thanks for banking at Globe Bank International");
        break;

        default: 
        System.out.println("Invalid Option. Please try again");
      }
    } 
  }
}
