import java.util.*;

public class MonoalphabeticCipher {


    public static String encrypt(String text, String key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                int index = alphabet.indexOf(ch);
                result += key.charAt(index);
            } else if (Character.isLowerCase(ch)) {
                int index = alphabet.indexOf(Character.toUpperCase(ch));
                result += Character.toLowerCase(key.charAt(index));
            } else {
                result += ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

        System.out.println("Enter the plaintext:");
        String text = sc.nextLine();

        String encrypted = encrypt(text, key);

        System.out.println("Encrypted text: " + encrypted);

        sc.close();
    }
}