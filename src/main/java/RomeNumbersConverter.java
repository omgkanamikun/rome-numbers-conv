import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

class RomeNumbersConverter {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

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

    private static String intToRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + intToRoman(number - l);
    }

    private static int getIntNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter integer number");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("That's not an integer!");
            }
        }
    }

    public static String getConvert() {
        return intToRoman(getIntNumber());
    }


    public static String getConvert(int n) {
        return intToRoman(n);
    }
}


