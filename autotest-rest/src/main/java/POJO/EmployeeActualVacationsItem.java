package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeActualVacationsItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("paid")
	private boolean paid;

	@SerializedName("vacation_request")
	private int vacationRequest;

	@SerializedName("memo")
	private String memo;

	@SerializedName("create_date")
	private String createDate;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public boolean isPaid(){
		return paid;
	}

	public int getVacationRequest(){
		return vacationRequest;
	}

	public String getMemo(){
		return memo;
	}

	public String getCreateDate(){
		return createDate;
	}

	public String getStartDate(){
		return startDate;
	}
}