package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeLanguagesItem{

	@SerializedName("level")
	private int level;

	@SerializedName("language")
	private int language;

	public int getLevel(){
		return level;
	}

	public int getLanguage(){
		return language;
	}
}