package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeProjectSalaryRatesItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("hourly_rate")
	private int hourlyRate;

	@SerializedName("employee_project")
	private int employeeProject;

	@SerializedName("memo")
	private String memo;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public int getHourlyRate(){
		return hourlyRate;
	}

	public int getEmployeeProject(){
		return employeeProject;
	}

	public String getMemo(){
		return memo;
	}

	public String getStartDate(){
		return startDate;
	}
}