import java.util.Arrays;
import java.util.Scanner;

public class Jaygasht {
    public static void main(String[] args) {
        System.out.println("pls enter your inputs");
        Scanner scanner = new Scanner(System.in);
        String inputedValue = scanner.nextLine();

        char[] charcterHolder = new char[inputedValue.length()];
        for (int i = 0; i < inputedValue.length(); i++) {
            charcterHolder[i] = inputedValue.charAt(i);
        }
        System.out.println(Arrays.toString(charcterHolder));
//or just simply use
        inputedValue.toCharArray();
        permute(charcterHolder, 0);


    }

    private static void permute(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(Arrays.toString(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;

                permute(chars, index + 1);

                temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;
            }
        }
    }
}
