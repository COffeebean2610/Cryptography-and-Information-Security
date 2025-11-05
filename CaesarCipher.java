import java.util.Scanner;

public class CaesarCipher{
    public static String encrypt(String text, int key) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + key) % 26 + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + key) % 26 + 'a');
            }
            result += ch;
        }
        return result;
    }
    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - (key % 26));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter key (number): ");
        int key = sc.nextInt();
        String encrypted = encrypt(text, key);
        System.out.println("Encrypted Text: " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}