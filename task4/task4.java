import java.io.*;
import java.nio.file.*;
import java.util.*;

public class task4 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Ошибка: не указан путь к файлу.");
        }
        String filename = args[0];
        //String filename = "task4/nums.txt";

        try {

            Scanner scanner= new Scanner(new File(filename));
            List<Integer> numbers = new ArrayList<>();
            while(scanner.hasNextDouble()) {
                numbers.add(scanner.nextInt());
            }
            Collections.sort(numbers);
            int median = numbers.get(numbers.size() / 2);
            int totalMoves = 0;
            for (int num : numbers) {
                totalMoves += Math.abs(num - median);
            }
           if (totalMoves <= 20) {
                System.out.println(totalMoves);
            } else {
                System.out.println("Превышено максимальное количество ходов.");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }



}