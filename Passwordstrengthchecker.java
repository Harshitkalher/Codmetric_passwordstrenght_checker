import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    // Function to check password strength
    public static String checkStrength(String password) {
        int score = 0;
        String suggestions = "Suggestions: ";

        // Check length
        if (password.length() >= 8) {
            score++;
        } else {
            suggestions += "Make it at least 8 characters long. ";
        }

        // Check for uppercase letters
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            score++;
        } else {
            suggestions += "Add at least one uppercase letter. ";
        }

        // Check for lowercase letters
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            score++;
        } else {
            suggestions += "Add at least one lowercase letter. ";
        }

        // Check for numbers
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            score++;
        } else {
            suggestions += "Include at least one number. ";
        }

        // Check for special characters
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            score++;
        } else {
            suggestions += "Use at least one special character (!@#$%^&* etc.). ";
        }

        // Determine strength based on score
        if (score <= 2) {
            return "Weak Password! " + suggestions;
        } else if (score == 3 || score == 4) {
            return "Moderate Password. Consider improving: " + suggestions;
        } else {
            return "Strong Password! Good job!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        // Check password strength and display result
        String result = checkStrength(password);
        System.out.println(result);

        scanner.close();
    }
}