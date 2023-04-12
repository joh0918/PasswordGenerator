import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Generates passwords for users and stores the new password in a txt file.
 */
public class PasswordGeneratorMain {

    public static void main(String[] args) {
        printLogo();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number to determine the length of the password: ");
        int length = in.nextInt();
        try {
            FileWriter myWriter = new FileWriter("password.txt");
            myWriter.write(passwordGenerator(length));
            myWriter.close();
            System.out.print("Your password is: ");
            System.out.println(passwordGenerator(length));
            System.out.println("Please refer to the txt file for password.");
            System.out.println("Exiting Program...");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // try
        
    } // main


    /**
     * Prints the logo.
     */
    public static void printLogo() {
        System.out.println(" ______                                   _   _____                           _             ");
        System.out.println("| ___ \\                                 | | |  __ \\                         | |            ");
        System.out.println("| |_/ /_ _ ___ _____      _____  _ __ __| | | |  \\/ ___ _ __   ___ _ __ __ _| |_ ___  _ __ ");
        System.out.println("|  __/ _` / __/ __\\ \\ /\\ / / _ \\| '__/ _` | | | __ / _ \\ '_ \\ / _ \\ '__/ _` | __/ _ \\| '__|");
        System.out.println("| | | (_| \\__ \\__ \\\\ V  V / (_) | | | (_| | | |_\\ \\  __/ | | |  __/ | | (_| | || (_) | |   ");
        System.out.println("\\_|  \\__,_|___/___/ \\_/\\_/ \\___/|_|  \\__,_|  \\____/\\___|_| |_|\\___|_|  \\__,_|\\__\\___/|_|   ");
    } // printLogo

    /**
     * Generates a random password.
     * @return password
     */
    public static String passwordGenerator(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String password = "";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password += characters.charAt(index);
        } // for

        return password;
    } // passwordGenerator
} // PasswordGeneratorMain