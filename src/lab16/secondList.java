package lab16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class secondList extends Thread {

    public static void numberCounter(List<String> listOfNumbers) {

        Map<String, Integer> number = new HashMap<>();

        for (String i : listOfNumbers) {
            Integer j = number.get(i);
            if (j == null)
                number.put(i, 1);
            else
                number.put(i, j + 1);
        }

        for (Map.Entry<String, Integer> val : number.entrySet()) {
            System.out.println("Number from second list " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }
    }

    public static void loadingTxtFile(List<String> list, Path path) {

        List<String> listOfNumbersAsStrings1;
        try {
            listOfNumbersAsStrings1 = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(listOfNumbersAsStrings1);

        for (String index : listOfNumbersAsStrings1) {
            StringTokenizer st1 = new StringTokenizer(index, ",");
            while (st1.hasMoreTokens()) {
                list.add(st1.nextToken());
            }
        }
    }

    public void run() {

        Path p2 = Paths.get("numbers2.txt");
        List<String> listOfNumbers2 = new ArrayList<>();

        System.out.println("Second list of numbers from 11-20 : ");
        loadingTxtFile(listOfNumbers2,p2);
        System.out.println("Second list of numbers occurrences count : ");
        numberCounter(listOfNumbers2);
        System.out.println("Second number list done!");
    }

}
