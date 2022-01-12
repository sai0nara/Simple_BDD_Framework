package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeePositionGradesItem{

	@SerializedName("change_date")
	private String changeDate;

	@SerializedName("grade")
	private int grade;

	@SerializedName("memo")
	private String memo;

	@SerializedName("position")
	private int position;

	public String getChangeDate(){
		return changeDate;
	}

	public int getGrade(){
		return grade;
	}

	public String getMemo(){
		return memo;
	}

	public int getPosition(){
		return position;
	}
}