import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Company class keeps track of the employees and the partnerInteractions.
 *
 * @author Pranav Chati
 *
 */
public class Company {
    // private String companyName;

    /**
     * List of Employees.
     */
    private List<String> employees;

    /**
     * List of Partners and their connections.
     */
    private Map<String, Queue<String>> partnerInteractions;

    /**
     * Strongest Connections Size.
     */
    private int strongestConnection;

    /**
     * Name of the Partner with the strongest connection.
     */
    private String strongestPartner;

    /**
     * Default No-Argument Constructor.
     */
    public Company() {
        this.strongestConnection = 0;
        this.strongestPartner = "";
        this.employees = new ArrayList<String>();
        this.partnerInteractions = new HashMap<>();
    }

    /**
     * Adds an employee to the company.
     *
     * @param employeeName
     *            the name of the employee as a string
     */
    public void addEmployee(String employeeName) {
        this.employees.add(employeeName);
    }

    /**
     * Show all of the employees that the current company has.
     */
    public void showEmployees() {
        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println(this.employees.get(i));
        }
    }

    /**
     * Adds a partner and employee connection to the contact.
     *
     * @param partnerName
     *            the name of the partner that has the connection
     * @param employeeName
     *            the name of the employee that has a contact with the partner
     * @param contactType
     *            the mode of contact
     * @requires partnerName /= <> and employeeName /= <>
     */
    public void addPartnerConnection(String partnerName, String employeeName,
            String contactType) {
        Queue<String> employee;
        if (this.partnerInteractions.containsKey(partnerName)) {
            employee = this.partnerInteractions.get(partnerName);
            employee.add(employeeName);
            employee.add(contactType);
        } else {
            employee = new LinkedList<>();
            employee.add(employeeName);
            employee.add(contactType);

            this.partnerInteractions.put(partnerName, employee);
        }

        if (employee.size() / 2 > this.strongestConnection) {
            this.strongestPartner = partnerName;
            this.strongestConnection = employee.size() / 2;
        }
    }

    /**
     * Finds the partner that has the greatest connection to the company and
     * returns the two-tuple of the name and the connection strength.
     *
     * @return [the two-tuple that shows the partner connection]
     */
    public String[] getMaxPartnerConnectionStrength() {
        //Declare a new String two-tuple in the form of an array
        String[] partnerConnection = new String[2];

        if (this.strongestPartner.equals("")) {
            partnerConnection = null;
        } else {
            partnerConnection[0] = this.strongestPartner;
            partnerConnection[1] = Integer.toString(this.strongestConnection);
        }

        /*
         * //the minimum partner connection to a company is 0 int max = 0;
         * boolean found = false;
         *
         * //go through partnerInteractions map to find maxConnection for
         * (Map.Entry<String, Queue<String>> partner : this.partnerInteractions
         * .entrySet()) { //an employee has a contact type so divide by 2 for
         * connection
         *
         * int currentValue = partner.getValue().size() / 2;
         *
         * if (currentValue > max) { found = true; max = currentValue;
         * partnerConnection[0] = partner.getKey(); partnerConnection[1] =
         * Integer.toString(currentValue); } }
         *
         * if (!found) { partnerConnection = null; }
         *
         */

        return partnerConnection;

    }

}
