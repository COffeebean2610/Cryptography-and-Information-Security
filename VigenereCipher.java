import java.util.*;

public class VigenereCipher {

    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char encryptedChar = (char) ((ch - base + shift) % 26 + base);
                result.append(encryptedChar);
                keyIndex++;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Vigenere Cipher\n");
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        String encryptedText = encrypt(plaintext, keyword);
        System.out.println("Encrypted text: " + encryptedText);

        sc.close();
    }
}
