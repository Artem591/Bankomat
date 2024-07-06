public class Card extends Info{

    public int pincode;

    public Card(String number, double balance, int pincode ){
        super(number, balance);
        this. pincode = pincode;
    }




    public  String ToString(){
        return super.toString() + " " + pincode;
    }


}
