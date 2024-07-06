public class Info {
    public String number;
    public double balance;

    public Info(String number, double balance){
        this.number = number;
        this.balance = balance;
    }
    public String GetCardNumber(){
        return number;
    }
    public  double getBalance() {
        return balance;
    }

    public  void Deposit(double money){
        if(money > 1000000)
            System.out.println("Слишком большой депозит");
        else
            balance += money;
    }
    public  void getMoney(double money){
        if(money > balance)
            System.out.println("Недостаточно средств");
        else
            balance -= money;
    }

    public String toString(){
        return number + " " + balance;
    }

}
