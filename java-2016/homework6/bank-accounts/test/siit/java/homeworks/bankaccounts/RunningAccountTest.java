package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.lang.model.util.SimpleElementVisitor6;

import org.junit.Test;

public class RunningAccountTest {

	@Test
	public void addFundsTest() {
		Date accountCreationTime = TestUtils.getDate(2016, 3, 15);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 50f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 6, 15);
		runningAccount.addFunds(5000);
		assertEquals(4850, runningAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void withdrawFundsTest() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 3, 15);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 50f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 3, 15);
		runningAccount.addFunds(5000);
		runningAccount.withdrawFunds(500);
		assertEquals(4500, runningAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void whenMultipleOperationCalled_balanceIsCorrectTest() throws InsufficientFundsException{
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SimpleBankAccount simpleBankAccount = new SimpleBankAccount(accountCreationTime, 5);
		simpleBankAccount.addFunds(2000);
		simpleBankAccount.withdrawFunds(100);
		simpleBankAccount.withdrawFunds(500);
		simpleBankAccount.addFunds(50);
		Date balanceInterogationTime = TestUtils.getDate(2016, 10, 1);
		assertEquals("for 4 months fees should be deducted:", 1405, simpleBankAccount.getBalance(balanceInterogationTime), 0);
	}
	
	private static class SimpleBankAccount extends BankAccount {

		public SimpleBankAccount(Date accountCreationDate, float monthlyFee) {
			super(accountCreationDate, monthlyFee);
		}

	}
	
}
