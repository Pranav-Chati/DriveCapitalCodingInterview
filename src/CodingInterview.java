import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class CodingInterview {

    public static void main(String[] args) {
        //declare a scanner
        Scanner commandLineInput = new Scanner(System.in);

        System.out.println("Enter Input File: ");

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //ask the user for the input file

        out.println("Enter Input File: ");
        String inputFileName = in.nextLine();

        try {
            BufferedWriter write = new BufferedWriter(
                    new FileWriter(inputFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //out.println("Enter OutputFile: ");
        // String outputFile = in.nextLine();

        //declare a file to write too
        SimpleReader inputFile = new SimpleReader1L(inputFileName);

        while (!inputFile.atEOS()) {
            String text = inputFile.nextLine();
            String[] values = text.split(" ");

            switch (values[0]) {
                case "Partner":
                    out.print("Partner");
                    break;

                case "Company":
                    out.print("Company");
                    break;

                default:
                    out.print("Nothing");
                    break;

            }
        }

        in.close();
        inputFile.close();
        out.close();
    }
}
