package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeCivilContractsItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("number")
	private String number;

	@SerializedName("is_endless")
	private boolean isEndless;

	@SerializedName("organisation")
	private int organisation;

	@SerializedName("memo")
	private String memo;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public String getNumber(){
		return number;
	}

	public boolean isIsEndless(){
		return isEndless;
	}

	public int getOrganisation(){
		return organisation;
	}

	public String getMemo(){
		return memo;
	}

	public String getStartDate(){
		return startDate;
	}
}