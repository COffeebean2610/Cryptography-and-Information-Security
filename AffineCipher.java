import java.util.Scanner;

public class AffineCipher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = s.next();
        int a = 3;
        int b = 7;
        String output = "";
        StringBuilder sb = new StringBuilder(output);

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char encryptchar = (char) ((((c - 'A') * a) + b) % 26 + 'A');
                sb.append(encryptchar);
            } else if (Character.isLowerCase(c)) {
                char encryptchar = (char) ((((c - 'a') * a) + b) % 26 + 'a');
                sb.append(encryptchar);
            } else {
                sb.append(c);
            }
        }
        String Ans = sb.toString();
        System.out.println(Ans);

        s.close();

    }
}