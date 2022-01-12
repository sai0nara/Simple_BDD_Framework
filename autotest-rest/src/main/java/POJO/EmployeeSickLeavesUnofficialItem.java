package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeSickLeavesUnofficialItem{

	@SerializedName("date")
	private String date;

	public String getDate(){
		return date;
	}
}