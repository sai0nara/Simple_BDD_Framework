package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeEducationsItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("institution")
	private int institution;

	@SerializedName("specialty")
	private int specialty;

	@SerializedName("show_in_resume")
	private boolean showInResume;

	@SerializedName("degree")
	private int degree;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public int getInstitution(){
		return institution;
	}

	public int getSpecialty(){
		return specialty;
	}

	public boolean isShowInResume(){
		return showInResume;
	}

	public int getDegree(){
		return degree;
	}

	public String getStartDate(){
		return startDate;
	}
}