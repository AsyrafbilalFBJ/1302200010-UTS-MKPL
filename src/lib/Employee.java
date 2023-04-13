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

	private List<Child> child;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.dateJoined = dateJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		child = new LinkedList<Child>();
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

        public LocalDate getDateJoined() {
		return dateJoined;
	}

	public boolean getIsForeigner() {
		return isForeigner;
	}

	public Gender getGender() {
		return gender;
	}

        public List<Child> getChildren() {
            return child;
        }

	public int getSizeChild(){
		return child.size();
	}

	public void addChild(Child child) {
            this.child.add(child);
	}
	
	
}
