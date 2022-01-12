package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeVacationRequestsItem{

	@SerializedName("request_status")
	private int requestStatus;

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("paid")
	private boolean paid;

	@SerializedName("memo")
	private String memo;

	@SerializedName("create_date")
	private String createDate;

	@SerializedName("start_date")
	private String startDate;

	public int getRequestStatus(){
		return requestStatus;
	}

	public String getEndDate(){
		return endDate;
	}

	public boolean isPaid(){
		return paid;
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