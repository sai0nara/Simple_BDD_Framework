package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeePreviousExperienceItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("responsibilities")
	private String responsibilities;

	@SerializedName("outside_role")
	private int outsideRole;

	@SerializedName("show_in_resume")
	private boolean showInResume;

	@SerializedName("organisation")
	private int organisation;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public String getResponsibilities(){
		return responsibilities;
	}

	public int getOutsideRole(){
		return outsideRole;
	}

	public boolean isShowInResume(){
		return showInResume;
	}

	public int getOrganisation(){
		return organisation;
	}

	public String getStartDate(){
		return startDate;
	}
}