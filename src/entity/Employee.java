package entity;

public class Employee {

	
	private int emId;
	public int getEmId() {
		return emId;
	}
	public void setEmId(int emId) {
		this.emId = emId;
	}
	public String getEmName() {
		return emName;
	}
	public void setEmName(String emName) {
		this.emName = emName;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	private String emName;
	private int dept_id;

}
