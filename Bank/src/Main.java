import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

            List<Card> cards = new ArrayList<>();
            WriteToFile write = new WriteToFile();
            try {
                FileReader fileReader = new FileReader("bank.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] line1 = line.split(" ");
                    String number = line1[0];
                    double balance = Double.parseDouble(line1[1]);
                    int pincode = Integer.parseInt(line1[2]);
                    Card card = new Card(number, balance, pincode);
                    cards.add(card);
                }
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }


            Scanner scanner = new Scanner(System.in);
            Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
            System.out.println("Введите номер банковской карточки в формате ХХХХ-ХХХХ-ХХХХ-ХХХХ:");
            while (!scanner.hasNext(pattern)) {
                System.out.println("Неверно, Пожалуйста введите номер банковской карточки в формате ХХХХ-ХХХХ-ХХХХ-ХХХХ:");
                scanner.next();
            }
            String num = scanner.next();
            for (Card card : cards) {
                int count = 0;
                if (card.number.equals(num)) {
                    count ++;
                    System.out.println("Введите пин-код");
                    int pin = scanner.nextInt();
                    if (card.pincode == pin) {
                        System.out.println("Если хотите положить деньги на счёт выберите 1, если снять, то 2. Для просмотра баланса выберите 3");
                        int a = scanner.nextInt();
                        while (true) {
                            if (a == 1) {
                                System.out.println("Сколько желаете положить на счёт?");
                                double bal = scanner.nextInt();
                                card.Deposit(bal);
                                break;

                            } else if (a == 2) {
                                System.out.println("Сколько желаете снять со счёта?");
                                double bal = scanner.nextInt();
                                card.getMoney(bal);
                                break;

                            } else if (a == 3) {
                                System.out.println("Balance: " + card.getBalance());
                                break;
                            } else {
                                System.out.println("Неверно,Введите 1 или 2 (Если хотите положить деньги на счёт выберите 1, если снять, то 2)");
                                a = scanner.nextInt();
                            }
                        }
                    }

                    write.writeListToFile(cards, "bank.txt");
                    if (count == 0)
                        System.out.println("Такой карточки не найдено");
                }





            }

    }
}