package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private LocalDate dateJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private Gender gender; 
	public enum Gender {
            MALE("Laki-Laki"),
            FEMALE("Perempuan");

            private String displayName;

            Gender(String displayName) {
                this.displayName = displayName;
            }

            public String getDisplayName() {
                return displayName;
            }
	}
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.dateJoined = dateJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public static final int FIRST_GRADE_SALARY = 3000000;
        public static final int SECOND_GRADE_SALARY = 5000000;
        public static final int THIRD_GRADE_SALARY = 7000000;
        private static final double SALARY_INCREASE_FOREIGN_EMPLOYEE = 1.5;

	public void setMonthlySalary(int grade) {	
		switch (grade) {
		    case 1:
			this.monthlySalary = FIRST_GRADE_SALARY;
			break;
		    case 2:
			this.monthlySalary = SECOND_GRADE_SALARY;
			break;
		    case 3:
			this.monthlySalary = THIRD_GRADE_SALARY;
			break;
		    default:
			throw new IllegalArgumentException("Invalid grade: " + grade);
		}
		if (isForeigner) {
		    this.monthlySalary =  (int) (this.monthlySalary * SALARY_INCREASE_FOREIGN_EMPLOYEE);
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setOtherMonthlyIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public void setMonthWorkingInYear(){
		LocalDate currentDate = LocalDate.now();
		
		if (currentDate.getYear() == this.dateJoined.getYear()) {
		    this.monthWorkingInYear = currentDate.getMonthValue() - this.dateJoined.getMonthValue();
		}else {
		    this.monthWorkingInYear = 12;
		}
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		setMonthWorkingInYear();
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
