import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class SimpleDES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Make DES key
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();

        // Take input
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        // Encrypt
        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes()));
        System.out.println("Encrypted: " + enc);

        // Decrypt
        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));
        System.out.println("Decrypted: " + dec);

        sc.close();
    }
}
