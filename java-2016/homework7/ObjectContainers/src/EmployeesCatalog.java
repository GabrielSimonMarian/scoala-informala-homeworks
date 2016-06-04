
public interface EmployeesCatalog {

	void addEmployee(Employee employee);

	void moveEmployeeAccordingToTheRank(String isManager);
	
	void moveEmployeesToJuniorsList(String isJunior);

	void printEmployeeFromList();

	void printManagers();

	void printJuniors();

	void getEmployeesWithoutParking(boolean hasParking);

	void printEmployeesWithoutParking();

	int numberOfEmployeesWithoutParking();
}
