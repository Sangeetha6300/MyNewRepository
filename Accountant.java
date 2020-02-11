package anurag;

class Person1 {
private String namme;
private float age;

public String getNamme() {
return namme;
}

public void setName(String name) {
this.namme = name;
}

public float getAge() {
return age;
}

public void setAge(float age) {
this.age = age;
}
}

abstract class Account1 {
private static long count = 0;
private long accNum;
public double balance;
private Person1 accHolder;

public long getAccNum() {
return accNum;
}

public void setAccNum(long accNum) {
this.accNum = accNum;
}

public Person1 getAccHolder() {
return accHolder;
}

public void setAccHolder(Person1 accHolder) {
this.accHolder = accHolder;
}

public void setBalance(double balance) {
this.balance = balance;
}

public void deposit(double amount) {
balance += amount;
}

public abstract void withdraw(double amount);
/*{
balance -= amount;
}*/

public double getBalance() {
return balance;
}

public Account1() {
accNum = ++count;
}

public String toString() {
return "Account Holder name: " + this.accHolder.getNamme() + "\nAge: " + this.accHolder.getAge()
+ "\nAccount Number: " + this.getAccNum() + " \nCurrent Balance: " + this.getBalance();
}
}

class SavingsAccount1 extends Account1 {
private final double minBalance = 1000;
double bal;

public void withdraw(double amount) {
bal = super.getBalance();
double bal1 = bal - amount;
if (bal > minBalance && bal1 >= minBalance) {

bal -= amount;
super.setBalance(bal);
} else {

System.out.println(" You can withdraw upto  " + (bal - minBalance));
}

}
}

class CurrentAccount1 extends Account1{
public double overdraftLimit = -1000;
double bal;

public void withdraw(double amount) {
bal = super.getBalance();
double bal1 = bal - amount;
if (bal > overdraftLimit && bal1 >= overdraftLimit) {

bal -= amount;
super.setBalance(bal);
System.out.println("false");
} else {

System.out.println(" You can withdraw upto  " + (bal - overdraftLimit));
System.out.println("overdraft amount reached");
}

}
}/*
class B extends Account{
public void withdraw(double amount)
{
balance -=amount;
}
}*/
public class Accountant extends Account1{

public static void main(String[] args) {
Person1 p1 = new Person1();
p1.setName("Smith");
p1.setAge(30);
Person1 p2 = new Person1();
p2.setName("Kathy");
p2.setAge(21);
CurrentAccount1 smithAcc = new CurrentAccount1();
smithAcc.setAccHolder(p1);
SavingsAccount1 kathyAcc = new SavingsAccount1();
kathyAcc.setAccHolder(p2);

smithAcc.setBalance(2000);
kathyAcc.setBalance(5000);
smithAcc.deposit(2000);

System.out.println("The updated smith account balance is " + smithAcc.getBalance());
System.out.println("The updated kathy account balance is " + kathyAcc.getBalance());
kathyAcc.withdraw(2000);
kathyAcc.withdraw(4500);
kathyAcc.withdraw(0);
smithAcc.withdraw(6000);
System.out.println(smithAcc.toString());
System.out.println(kathyAcc.toString());

}

@Override
public void withdraw(double amount) {
// TODO Auto-generated method stub
balance -=amount;
}
}



