import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Drive Capital Online Coding Interview response.
 *
 * @author Pranav Chati
 *
 */
public final class AnalyzeNetwork {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private AnalyzeNetwork() {

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //initialize variables for file scanning
        Scanner cmdLineInput = new Scanner(System.in);

        //declare variables for holding Partner and Company information
        List<String> listOfPartners = new ArrayList<>();
        Map<String, Company> listOfCompanies = new HashMap<>();
        Map<String, String> listOfEmployees = new HashMap<>();

        System.out.println("Enter Input File: ");
        String inputFileName = cmdLineInput.nextLine();

        try {
            //create a new file reader
            BufferedReader inputFile = new BufferedReader(
                    new FileReader(inputFileName));

            //read file line by line
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] fileCommands = line.split(" ");

                //declare variables
                String partnerName;
                String companyName;
                String employeeName;
                String contactType;
                Company company;

                //length of the command and its space after
                int lengthOfCommand = fileCommands[0].length() + 1;

                switch (fileCommands[0].toUpperCase()) {
                    case "PARTNER":
                        partnerName = line.substring(lengthOfCommand);
                        listOfPartners.add(partnerName);
                        break;

                    case "COMPANY":
                        //accounts if the company name is greater than 1 word
                        companyName = line.substring(lengthOfCommand);

                        //create a new company name and add it to the company
                        listOfCompanies.put(companyName, new Company());
                        break;

                    case "EMPLOYEE":
                        //declare employeeName and companyName
                        employeeName = fileCommands[1];
                        lengthOfCommand += employeeName.length() + 1;
                        companyName = line.substring(lengthOfCommand);
                        listOfEmployees.put(employeeName, companyName);

                        //add employee to company
                        company = listOfCompanies.get(companyName);

                        //check for null dereference pointer
                        if (company != null) {
                            //System.out.println("EMPLOYEE - Company Exists");

                            company.addEmployee(employeeName);
                        }
                        break;

                    case "CONTACT":
                        employeeName = fileCommands[1];
                        partnerName = fileCommands[2];
                        contactType = fileCommands[fileCommands.length - 1];

                        if (listOfEmployees.containsKey(employeeName)
                                && listOfPartners.contains(partnerName)) {
                            company = listOfCompanies
                                    .get(listOfEmployees.get(employeeName));

                            if (company != null) {
                                company.addPartnerConnection(partnerName,
                                        employeeName, contactType);
                            }
                        }
                        break;

                    default:
                        System.out.println("This command does not exist.");
                        break;
                }
            }

            for (Map.Entry<String, Company> companyElement : listOfCompanies
                    .entrySet()) {
                String[] maxConnection = companyElement.getValue()
                        .getMaxPartnerConnectionStrength();

                System.out.print(companyElement.getKey() + ": ");
                if (maxConnection != null) {
                    System.out.println(
                            maxConnection[0] + " (" + maxConnection[1] + ")");
                } else {
                    System.out.println("No Current Relationship");
                }

            }

            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        cmdLineInput.close();
    }
}
