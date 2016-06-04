import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeesTests {

	EmployeesCatalog allEmployeeList = new EmployeesManagement();

	@Before
	public void setUp() {
		allEmployeeList.addEmployee(new Employee("Doru Dima", "Manager", 10, true));
		allEmployeeList.addEmployee(new Employee("Dan Anca", "Manager", 8, false));
		allEmployeeList.addEmployee(new Employee("Geo Bogza", "Junior", 5, true));
		allEmployeeList.addEmployee(new Employee("Aurel Vlaicu", "Junior", 2, false));
		allEmployeeList.addEmployee(new Employee("Ion Glanetasu", "Manager", 1, false));

	}

	@Test
	public void testArrayList() {
		Assert.assertNotNull("List must not be null.", allEmployeeList);
	}

	@Test
	public void testIfReturnAtributtesAreTrue() {
		assertEquals(3, allEmployeeList.numberOfEmployeesWithoutParking(), 0);
	}
}

/*
 * @Test public void whenMonthlyFeeIs0_balanceIsNotModified() { Date
 * accountCreationTime = TestUtils.getDate(2016, 1, 1); SimpleBankAccount
 * simpleBankAccount = new SimpleBankAccount(accountCreationTime, 0);
 * simpleBankAccount.addFunds(1000); Date balanceInterogationTime =
 * TestUtils.getDate(2016, 5, 1); assertEquals(1000,
 * simpleBankAccount.getBalance(balanceInterogationTime), 0); }
 */