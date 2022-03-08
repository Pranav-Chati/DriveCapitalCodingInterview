import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public final class CodingInterview {

    public static void main(String[] args) throws IOException {
        //declare a scanner for file input
        Scanner cmdLineInput = new Scanner(System.in);
        BufferedReader inputFile = null;

        System.out.println("Enter Input File: ");
        String inputFileName = cmdLineInput.nextLine();

        try {
            inputFile = new BufferedReader(new FileReader(inputFileName));
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] commands = line.split(" ");
                switch (commands[0].toLowerCase()) {
                    case "partner":
                        System.out.println("Partner " + commands[1]);
                        break;

                    case "company":
                        System.out.println("Company");
                        break;

                    case "employee":
                        System.out.println("Employee");
                        break;

                    case "contact":
                        System.out.println("Contact");
                        break;

                    default:
                        System.out.println("This command does not work");
                        break;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        cmdLineInput.close();
    }
}
