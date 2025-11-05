import java.math.BigInteger;
import java.util.Scanner;

public class Diffie_Hellman {

    // check if number is prime
    public static boolean isPrime(BigInteger n) {
        return n.isProbablePrime(20); // Miller-Rabin test (probabilistic but strong)
    }

    // check if g is primitive root modulo p
    public static boolean isPrimitiveRoot(BigInteger g, BigInteger p) {
        int prime = p.intValue();
        int alpha = g.intValue();

        boolean[] visited = new boolean[prime];
        int value = 1;

        for (int k = 1; k < prime; k++) {
            value = (value * alpha) % prime;
            if (visited[value]) {
                return false;
            }
            visited[value] = true;
        }

        for (int i = 1; i < prime; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input prime number q
        BigInteger prime;
        while (true) {
            System.out.print("Enter a prime number (q): ");
            prime = sc.nextBigInteger();
            if (isPrime(prime)) {
                break;
            } else {
                System.out.println(prime + " is NOT prime. Try again.");
            }
        }

        // input primitive root
        BigInteger g;
        while (true) {
            System.out.print("Enter a primitive root modulo q (alpha): ");
            g = sc.nextBigInteger();
            if (isPrimitiveRoot(g, prime)) {
                System.out.println("\n" + g + " is a valid primitive root modulo " + prime);
                break;
            } else {
                System.out.println(g + " is NOT a primitive root modulo " + prime + ". Try again.");
            }
        }

        // input private key Xa
        BigInteger privateKeyAlice;
        while (true) {
            System.out.print("Enter value of Xa (1 < Xa < " + (prime.subtract(BigInteger.ONE)) + "): ");
            privateKeyAlice = sc.nextBigInteger();
            if (privateKeyAlice.compareTo(BigInteger.ONE) > 0 &&
                    privateKeyAlice.compareTo(prime.subtract(BigInteger.ONE)) < 0) {
                break;
            } else {
                System.out.println("Invalid Xa. Must be between 1 and q-1.");
            }
        }

        // input private key Xb
        BigInteger privateKeyBob;
        while (true) {
            System.out.print("Enter value of Xb (1 < Xb < " + (prime.subtract(BigInteger.ONE)) + "): ");
            privateKeyBob = sc.nextBigInteger();
            if (privateKeyBob.compareTo(BigInteger.ONE) > 0 &&
                    privateKeyBob.compareTo(prime.subtract(BigInteger.ONE)) < 0) {
                break;
            } else {
                System.out.println("Invalid Xb. Must be between 1 and q-1.");
            }
        }

        // compute public keys
        BigInteger publicKeyAlice = g.modPow(privateKeyAlice, prime);
        BigInteger publicKeyBob = g.modPow(privateKeyBob, prime);

        System.out.println("\nPublic Key Calculation");
        System.out.println("Xa's Public Key: " + publicKeyAlice);
        System.out.println("Xb's Public Key: " + publicKeyBob);

        // compute shared secrets
        BigInteger sharedSecretAlice = publicKeyBob.modPow(privateKeyAlice, prime);
        BigInteger sharedSecretBob = publicKeyAlice.modPow(privateKeyBob, prime);

        System.out.println("\nShared Secret Calculation");
        System.out.println("Shared Secret (Ya): " + sharedSecretAlice);
        System.out.println("Shared Secret (Yb): " + sharedSecretBob);

        if (sharedSecretAlice.equals(sharedSecretBob)) {
            System.out.println("\nBoth parties share the SAME secret key: " + sharedSecretAlice);
        } else {
            System.out.println("\nSecrets do NOT match.");
        }

        sc.close();
    }
}
