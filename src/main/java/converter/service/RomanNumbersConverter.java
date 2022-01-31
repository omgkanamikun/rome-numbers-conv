package converter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class RomanNumbersConverter implements NumbersConverter {

    private static final Logger log = LoggerFactory.getLogger(RomanNumbersConverter.class);
    private static final TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    @Override
    public String convert(int number) {
        return intToRoman(number);
    }

    @Override
    public String convert() {
        return intToRoman(scanIntNumber());
    }

    private String intToRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + intToRoman(number - l);
    }

    private int scanIntNumber() {
        try (final var scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    log.info("Enter the integer number");
                    return scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.next();
                    log.info("That's not an integer!");
                }
            }
        }
    }
}
