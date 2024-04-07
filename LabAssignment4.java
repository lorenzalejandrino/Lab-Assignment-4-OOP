import java.util.Scanner;

class TooManyLoginAttempts extends Exception {
    public TooManyLoginAttempts(String message) {
    super(message);
    }
}
class PasswordError extends Exception {
    public PasswordError(String message) {
    super(message);
    }
}
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int remainingAttempts = 3;

    while (remainingAttempts > 0) {
    System.out.print("Enter Password: ");
    String enteredPassword = scanner.nextLine();
    remainingAttempts--;

    if (enteredPassword.equals("password")) {
    System.out.println("Login successful!!!");
    break;
    } else if (remainingAttempts > 0) {
        try {
        throw new PasswordError("Invalid password. Tries left: " + remainingAttempts);
        } catch (PasswordError e) {
        System.out.println(e.getMessage());
        }
        }
    }
    if (remainingAttempts == 0) {
        try {
        throw new TooManyLoginAttempts("Maximum login attempts exceeded.");
        } catch (TooManyLoginAttempts e) {
        System.out.println(e.getMessage());

        }
        }
    }
}
