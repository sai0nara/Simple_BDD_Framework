package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeFamilyItem{

	@SerializedName("type_of_relationship")
	private int typeOfRelationship;

	@SerializedName("patronymic")
	private String patronymic;

	@SerializedName("address")
	private String address;

	@SerializedName("phone")
	private String phone;

	@SerializedName("surname")
	private String surname;

	@SerializedName("name")
	private String name;

	@SerializedName("birth")
	private String birth;

	public int getTypeOfRelationship(){
		return typeOfRelationship;
	}

	public String getPatronymic(){
		return patronymic;
	}

	public String getAddress(){
		return address;
	}

	public String getPhone(){
		return phone;
	}

	public String getSurname(){
		return surname;
	}

	public String getName(){
		return name;
	}

	public String getBirth(){
		return birth;
	}
}