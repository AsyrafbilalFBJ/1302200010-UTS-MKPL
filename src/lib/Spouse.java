package lib;

public class Spouse extends Employee {
    private String spouseName;
    private String spouseIdNumber;

    public Spouse(Employee employee, String spouseName, String spouseIdNumber) {
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
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }
    
    public String getSpouseName() {
        return spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }
}
