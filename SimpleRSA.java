import java.util.Scanner;

public class SimpleRSA {
    // Function to calculate gcd
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to calculate modular inverse (d)
    static int modInverse(int e, int phi) {
        e = e % phi;
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1) {
                return d;
            }
        }
        return 1;
    }

    // Function for modular exponentiation (a^b mod n)
    static int powerMod(int a, int b, int n) {
        int result = 1;
        a = a % n;
        for (int i = 0; i < b; i++) {
            result = (result * a) % n;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input p, q and plain text
        System.out.print("Enter prime number p: ");
        int p = sc.nextInt();
        System.out.print("Enter prime number q: ");
        int q = sc.nextInt();
        System.out.print("Enter plain text (integer): ");
        int pt = sc.nextInt();

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        // Choose e (public key exponent)
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1) break;
            else e++;
        }

        // Compute d (private key exponent)
        int d = modInverse(e, phi);

        // Encryption: (pt^e) mod n
        int ct = powerMod(pt, e, n);

        // Decryption: (ct^d) mod n
        int dt = powerMod(ct, d, n);

        // Print values
        System.out.println("\np = " + p);
        System.out.println("q = " + q);
        System.out.println("n (p*q) = " + n);
        System.out.println("phi = " + phi);
        System.out.println("e = " + e);
        System.out.println("d = " + d);
        System.out.println("Plain Text = " + pt);
        System.out.println("Cipher Text = " + ct);
        System.out.println("Decrypted Text = " + dt);

        sc.close();
    }
}
