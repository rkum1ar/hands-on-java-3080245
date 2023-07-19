package bank;

import bank.exceptions.AmountException;

public class Account {
  private int Id;
  private String type;
  private double balance;

  public Account(int Id, String type, double balance) {
    setId(Id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.Id;
  }

  public void setId(int Id) {
    this.Id = Id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
public void deposit(double amount)throws AmountException{
if(amount<0)
{
  throw new AmountException(" The aminimum deposit us 1.00");
}
else {
  double newBalance = balance + amount;
  setBalance(newBalance);
  DataSource.updateAccountBalance(Id, newBalance);
}
} 
public void withdraw(double amount)throws AmountException{
  if(amount<0){
    throw new AmountException("The withdrawal amust be greateer than 0.");
  }else if(amount>getBalance()){
    throw new AmountException("You do not have sufficient funds for this withdrawal.");
  }
  else{
    double newBalance= balance-amount;
    setBalance(newBalance);
    DataSource.updateAccountBalance(Id, newBalance);
  }
}
}
