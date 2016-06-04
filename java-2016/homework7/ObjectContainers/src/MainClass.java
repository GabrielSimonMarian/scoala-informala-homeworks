
public class MainClass {

	public static void main(String[] args) {

		EmployeesCatalog allEmployeeList = new EmployeesManagement();

		String isManager = "Manager";
		String isJunior = "Junior";
		boolean hasParking = false;

		allEmployeeList.addEmployee(new Employee("Doru Dima", "Manager", 10, true));
		allEmployeeList.addEmployee(new Employee("Dan Anca", "Manager", 8, false));
		allEmployeeList.addEmployee(new Employee("Geo Bogza", "Junior", 5, true));
		allEmployeeList.addEmployee(new Employee("Aurel Vlaicu", "Junior", 2, false));
		allEmployeeList.addEmployee(new Employee("Ion Glanetasu", "Manager", 1, false));

		System.out.println("The following list contains the all employees: ");
		allEmployeeList.printEmployeeFromList();

		System.out.println("The following list contains the managers: ");
		allEmployeeList.moveEmployeeAccordingToTheRank(isManager);
		allEmployeeList.printManagers();

		System.out.println("The following list contains the juniors: ");
		allEmployeeList.moveEmployeesToJuniorsList(isJunior);
		allEmployeeList.printJuniors();

		System.out.println("The following list contains employees without parking: ");
		allEmployeeList.getEmployeesWithoutParking(hasParking);
		allEmployeeList.printEmployeesWithoutParking();

		System.out.println("Number of employees without parking: ");
		allEmployeeList.numberOfEmployeesWithoutParking();

		System.exit(0);
	}
}
