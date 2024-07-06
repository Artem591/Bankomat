import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public static void writeListToFile(List<Card> cards, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Card card : cards) {
                writer.write(card.number + " ");
                String balance1 = Double.toString(card.balance);
                writer.write(balance1 + " ");
                String pincode1 = Integer.toString(card.pincode);
                writer.write(pincode1);
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}

