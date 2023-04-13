package lib;

import java.time.LocalDate;

public class Salary extends Employee{
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private int monthWorkingInYear;
    Spouse spouse;

    public Salary (Employee employee, Spouse spouse, int monthlySalary, int otherMonthlyIncome, int annualDeductible){
        super(
            employee.getEmployeeId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getIdNumber(),
            employee.getAddress(),
            employee.getDateJoined(),
            employee.getIsForeigner(),
            employee.getGender()
        );
        setMonthlySalary(monthlySalary);
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
        this.spouse = spouse;
    }

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
            if (getIsForeigner()) {
                this.monthlySalary =  (int) (this.monthlySalary * SALARY_INCREASE_FOREIGN_EMPLOYEE);
            }
    }

    public void setAnnualDeductible(int deductible) {	
        this.annualDeductible = deductible;
    }
	
    public void setOtherMonthlyIncome(int income) {	
        this.otherMonthlyIncome = income;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public int getMonthWorkingInYear(){
        LocalDate currentDate = LocalDate.now();
        if (currentDate.getYear() == super.getDateJoined().getYear()) {
            this.monthWorkingInYear = currentDate.getMonthValue() - super.getDateJoined().getMonthValue();
        }else {
            this.monthWorkingInYear = 12;
        }
        return monthWorkingInYear;
    }

    public int getAnnualIncomeTax() {

        return TaxFunction.calculateTax(getMonthlySalary(), getOtherMonthlyIncome(), getMonthWorkingInYear(), getAnnualDeductible(), spouse.getSpouseIdNumber().equals(""), super.getSizeChild());
        
    }
}
