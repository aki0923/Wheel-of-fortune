package myProjects;
import java.util.ArrayList;
import java.util.Scanner;
public class WheelOfFortune {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> userNameList = new ArrayList<>();
    static int amountOfPlayers = 0;
    public static void solveNames(){
        amountOfPlayers= sc.nextInt();
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("What is your name?");
            userNameList.add(sc.next());
        }
    }

    public static void main(String[] args) {
    System.out.println("Welcome to the Wheel of Fortune");
    System.out.println("How many players?");
    solveNames();
    
    }
}
