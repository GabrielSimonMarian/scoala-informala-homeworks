import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	public String name;
	private String rank;
	private int yearsInCompany;
	private boolean hasParking;

	public Employee(String name, String rank, int yearsInCompany, boolean hasParking) {
		super();
		this.name = name;
		this.rank = rank;
		this.yearsInCompany = yearsInCompany;
		this.hasParking = hasParking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getYearsInCompany() {
		return yearsInCompany;
	}

	public void setYearsInCompany(int yearsInCompany) {
		this.yearsInCompany = yearsInCompany;
	}

	public boolean getHasParking() {
		return hasParking;
	}

	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", rank: " + rank + ", yearsInCompany: " + yearsInCompany + ", hasParking: " + hasParking + "";
	}

	public class YearsInCompanyComparatorComparator implements Comparator<Employee> {
		public int compare(Employee chair1, Employee chair2) {
			return chair1.getYearsInCompany() - chair2.getYearsInCompany();
		}
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
