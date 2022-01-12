package POJO;

import com.google.gson.annotations.SerializedName;

public class Citizenship{

	@SerializedName("name")
	private String name;

	public String getName(){
		return name;
	}
}