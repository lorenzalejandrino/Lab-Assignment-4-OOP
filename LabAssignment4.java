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
    int attempts = 3;

    while (attempts > 0) {
    System.out.print("Enter Password: ");
    String enteredPassword = scanner.nextLine();
    attempts--;

    if (enteredPassword.equals("password")) {
    System.out.println("Login successful!!!");
    break;
    } else if (attempts > 0) {
        try {
        throw new PasswordError("Invalid password. Tries left: " + attempts);
        } catch (PasswordError e) {
        System.out.println(e.getMessage());
        }
        }
    }
    if (attempts == 0) {
        try {
        throw new TooManyLoginAttempts("Maximum login attempts exceeded.");
        } catch (TooManyLoginAttempts e) {
        System.out.println(e.getMessage());

        }
        }
    }
}
