import java.util.ArrayList;
import java.util.List;

/**
 * Company class.
 *
 * @author pranavchati
 *
 */
public class Company {
    /**
     * Company Name.
     */
    private String companyName;

    /**
     * List of Employees.
     */
    private List<String> employees;

    /**
     * Default No-Args Constructor.
     */
    public Company() {
        this.companyName = "";
        this.employees = new ArrayList<String>();
    }

    /**
     * Argument Constructor.
     *
     * @param cName
     *            name of the company being created
     */
    public Company(String cName) {
        this.companyName = cName;
        this.employees = new ArrayList<String>();
    }

    /**
     *
     * @param employeeName
     *            the name of the employee as a string
     */
    public void addEmployee(String employeeName) {
        this.employees.add(employeeName);
    }

    public void showEmployees() {
        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println(this.employees.get(i));
        }
    }

    /**
     * Change the company name.
     *
     * @param companyName
     */
    public void changeCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
