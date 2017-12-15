
public class User {
	// attributes
	private String name, mail, phone;
	private int age;
	private DatabaseController databaseController;

	//Getter  & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public DatabaseController getSearch() {
		return databaseController;
	}
	public void setSearch(DatabaseController databaseController) {
		this.databaseController = databaseController;
	}
}
