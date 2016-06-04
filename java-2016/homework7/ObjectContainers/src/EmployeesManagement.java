import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeesManagement implements EmployeesCatalog {

	int employeesWithoutParkingCounter = 0;

	private List<Employee> allEmployeeList = new ArrayList<Employee>();

	private List<Employee> managersList = new ArrayList<Employee>();
	private List<Employee> juniorsList = new ArrayList<Employee>();

	private List<Employee> employeesWithoutParking = new ArrayList<Employee>();

	@Override
	public void printEmployeeFromList() {
		for (Employee employee : allEmployeeList) {
			System.out.println(employee);
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		allEmployeeList.add(employee);

	}

	@Override
	public void moveEmployeeAccordingToTheRank(String isManager) {
		for (Employee employee : allEmployeeList) {
			if (employee.getRank().equalsIgnoreCase(isManager)) {
				managersList.add(employee);
			}
		}

	}

	public void printManagers() {
		for (Employee employee : managersList)
			System.out.println(employee);
	}

	@Override
	public void printJuniors() {
		for (Employee employee : juniorsList)
			System.out.println(employee);

	}

	@Override
	public void moveEmployeesToJuniorsList(String isJunior) {
		for (Employee employee : allEmployeeList) {
			if (employee.getRank().equalsIgnoreCase(isJunior)) {
				juniorsList.add(employee);
			}
		}

	}

	@Override
	public void getEmployeesWithoutParking(boolean hasParking) {

		for (Employee employee : allEmployeeList) {
			if (employee.getHasParking() == false) {
				employeesWithoutParking.add(employee);
			}
		}
	}

	@Override
	public void printEmployeesWithoutParking() {
		Collections.sort(allEmployeeList, new Comparator<Employee>() {
			public int compare(Employee p1, Employee p2) {

				if (p1.getYearsInCompany() > p2.getYearsInCompany()) {
					return 1;
				} else if (p1.getYearsInCompany() < p2.getYearsInCompany()) {
					return -1;
				}

				return 0;
			}
		});

		for (Employee employee : employeesWithoutParking)
			System.out.println(employee);
	}

	public int numberOfEmployeesWithoutParking() {

		for (Employee employee : allEmployeeList) {
			if (employee.getHasParking() == false)
				employeesWithoutParkingCounter++;
		}
		return employeesWithoutParkingCounter;
	}

}
