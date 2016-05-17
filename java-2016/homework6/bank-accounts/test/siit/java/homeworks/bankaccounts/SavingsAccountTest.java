package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class SavingsAccountTest {

	private float expectedBalance;

	@Test
	public void addFundsTest() {
		Date accountCreationTime = TestUtils.getDate(2016, 3, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 50f, 0.002f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 6, 1);
		savingsAccount.addFunds(10000f);
		assertEquals(9850f, savingsAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void withdrawFundsTest() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 3, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 50f, 0.002f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 6, 1);
		savingsAccount.addFunds(10000f);
		savingsAccount.withdrawFunds(5000f);
		assertEquals(4840f, savingsAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void calculateInterestTest(){
		Date accountCreationTime = TestUtils.getDate(2016, 3, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 50f, 0.002f, 0.06f);
		savingsAccount.addFunds(10000f);
		Date balanceInterogationTime = TestUtils.getDate(2020, 3, 1);
		assertEquals(9424f, savingsAccount.calculateInterest(balanceInterogationTime), 0);
	}
	
	@Test
	public void whenMultipleOperationsCalled_balanceIsCorrect() throws InsufficientFundsException {
		// given
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		float withdrawalCommision = 0.02f;
		float credit = 10000f;
		float interest = 0.06f;
		float monthlyFee = 0.2f;
		SavingsAccount SavingsAccount = new SavingsAccount(accountCreationTime, monthlyFee, withdrawalCommision, interest);
		
		// when
		SavingsAccount.addFunds(9899f);
		SavingsAccount.withdrawFunds(200f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		float actualBalance = SavingsAccount.getBalance(balanceInterogationTime);
		
		// then
		float withdrawals = (100f + 100f * withdrawalCommision) + (200f + 200f * withdrawalCommision);
		float expectedBalance = credit - withdrawals;

		assertEquals("4 months worth of fees and the penalty should have been deducted.", expectedBalance,
				actualBalance, 0.3f);
	}
	
	@Test
	public void monthlyFeesAreNotApplied() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 50f, 0.002f, 0.06f);
		savingsAccount.addFunds(1000f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(800, savingsAccount.getBalance(balanceInterogationTime), 0);
	}
	
}
