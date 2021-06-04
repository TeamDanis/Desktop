package db_clases;

public class Students_data {
	
	String dni;
	String name;
	String first_surname;
	String second_surname;
	String phone_number;
	String mail;
	
	public Students_data() {
		super();
	}
	
	public Students_data(String dni, String name, String first_surname, String second_surname, String phone_number, String mail) {
		super();
		this.dni = dni;
		this.name = name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
		this.phone_number = phone_number;
		this.mail = mail;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_surname() {
		return first_surname;
	}

	public void setFirst_surname(String first_surname) {
		this.first_surname = first_surname;
	}

	public String getSecond_surname() {
		return second_surname;
	}

	public void setSecond_surname(String second_surname) {
		this.second_surname = second_surname;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Students_data [dni=" + dni + ", name=" + name + ", first_surname=" + first_surname + ", second_surname="
				+ second_surname + ", phone_number=" + phone_number + ", mail=" + mail + "]";
	}

}
