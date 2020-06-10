package at.ciit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.beans.XMLEncoder;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author michael.schaffler@ciit.at
 * https://www.ciit.at
 */
public class TestGraalVm {

    //java -Xmx5g -Xms5g at.ciit.TestGraalVm 5000000
    public static void main(String[] args) {
        for (int j = 0; j < 2; j++) {


            long start = System.currentTimeMillis();

            int sum = new Random().ints(Integer.valueOf(args[0]))
                    .mapToObj(randomNumber -> new SomeDataClass(String.valueOf(randomNumber), randomNumber, LocalDate.ofEpochDay(randomNumber)))
                    .sorted(Comparator.comparing(SomeDataClass::getDate))
                    .map(d -> d.toString())
                    .map(s -> s.length())
                    .mapToInt(i -> i)
                    .sum();
            System.out.println("Some useless number: " + sum);

            long duration = System.currentTimeMillis() - start;
            System.out.println("Duration in ms: " + duration);
        }
    }
}

class SomeDataClass {
    String string;
    double number;
    LocalDate date;

    public SomeDataClass(String string, double number, LocalDate date) {
        this.string = string;
        this.number = number;
        this.date = date;
    }

    public String getString() {
        return string;
    }

    public double getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toJson() {
        return new StringBuilder().append(string).append(",").append(number).append(",").append(date).toString();
    }
}



