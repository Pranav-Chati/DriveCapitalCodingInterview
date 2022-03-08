import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class CodingInterview {

    public static void main(String[] args) {
        //initialize variables for file scanning
        Scanner cmdLineInput = new Scanner(System.in);

        //declare variables for holding Partner and Company information
        //Set<String> partners = new Set<>();
        Map<String, Company> companies = new HashMap<>();
        Map<String, String> employees = new HashMap<>();

        System.out.println("Enter Input File: ");
        String inputFileName = cmdLineInput.nextLine();

        //System.out.println("Enter Output File: ");
        //String outputFileName = cmdLineInput.nextLine();

        try {
            //create a new file reader
            BufferedReader inputFile = new BufferedReader(
                    new FileReader(inputFileName));

            //read file line by line
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] fileCommands = line.split(" ");
                //length of the command and its space after
                int lengthOfCommand = fileCommands[0].length() + 1;

                switch (fileCommands[0].toUpperCase()) {
                    case "PARTNER":
                        String partnerName = line.substring(lengthOfCommand);

                        //insert partnerName into partners set?
                        break;

                    case "COMPANY":
                        //accounts if the company name is greater than 1 word
                        String companyName = line.substring(lengthOfCommand);

                        //create a new company name and add it to the company
                        companies.put(companyName, new Company(companyName));
                        break;

                    case "EMPLOYEE":
                        //find employeeName and companyName
                        String employeeName = fileCommands[1];
                        lengthOfCommand += employeeName.length() + 1;
                        companyName = line.substring(lengthOfCommand);

                        //add employee to company
                        Company company = companies.get(companyName);

                        //check for null dereference pointer
                        if (company != null) {
                            company.addEmployee(employeeName);
                        }
                        break;

                    case "CONTACT":
                        //System.out.println("Contact");
                        break;

                    default:
                        System.out.println("This command does not exist.");
                        break;

                }

            }

            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        cmdLineInput.close();
    }
}
