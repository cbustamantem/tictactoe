package tictactoe.com;

import java.io.Console;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AppTicTacToe
{
    public static void main( String[] args )
    {
        new AppTicTacToe().start();
    }
    public void start(){
        Structure structure = new Structure ();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the input game:");
        System.out.print("\n line1:");
        String line1 =scanner.nextLine();
        System.out.print("\n line2:");
        String line2= scanner.nextLine();
        System.out.print("\n line3:");
        String line3= scanner.nextLine();
        System.out.println("---------------------------");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        structure.parseLine(line1,0);
        structure.parseLine(line1,1);
        structure.parseLine(line1,2);
        structure.printStructure();
    }
}

