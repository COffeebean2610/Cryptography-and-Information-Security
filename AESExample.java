import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AESExample {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Make AES key
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey key = kg.generateKey();   

        // Take input
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        // Encrypt
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal(msg.getBytes());
        String encText = Base64.getEncoder().encodeToString(enc);
        System.out.println("Encrypted: " + encText);

        // Decrypt
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(Base64.getDecoder().decode(encText));
        String decText = new String(dec);
        System.out.println("Decrypted: " + decText);

        sc.close();
    }
}
