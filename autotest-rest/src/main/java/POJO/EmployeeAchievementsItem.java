package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeAchievementsItem{

	@SerializedName("achievement")
	private int achievement;

	@SerializedName("change_date")
	private String changeDate;

	@SerializedName("memo")
	private String memo;

	public int getAchievement(){
		return achievement;
	}

	public String getChangeDate(){
		return changeDate;
	}

	public String getMemo(){
		return memo;
	}
}