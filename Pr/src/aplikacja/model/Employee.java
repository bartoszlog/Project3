package aplikacja.model;



public class Employee {
	
	private int id;
	private String firstName;	
	private String lastName;
	private String salary1;
	private String salary2;



	public String getSalary1() {
		return salary1;
	}

	public void setSalary1(String salary1) {
		this.salary1 = salary1;
	}

	public String getSalary2() {
		return salary2;
	}

	public void setSalary2(String salary2) {
		this.salary2 = salary2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName, String salary1, String salary2){
		

		this.firstName = firstName;
		this.lastName = lastName;
		this.salary1 = salary1;
		this.salary2 = salary2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
