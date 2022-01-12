package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeProjectsItem{

	@SerializedName("feedback")
	private String feedback;

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("responsibilities")
	private String responsibilities;

	@SerializedName("is_trainee")
	private boolean isTrainee;

	@SerializedName("project_role")
	private int projectRole;

	@SerializedName("show_in_resume")
	private boolean showInResume;

	@SerializedName("project")
	private int project;

	@SerializedName("testing_type")
	private int testingType;

	@SerializedName("start_date")
	private String startDate;

	public String getFeedback(){
		return feedback;
	}

	public String getEndDate(){
		return endDate;
	}

	public String getResponsibilities(){
		return responsibilities;
	}

	public boolean isIsTrainee(){
		return isTrainee;
	}

	public int getProjectRole(){
		return projectRole;
	}

	public boolean isShowInResume(){
		return showInResume;
	}

	public int getProject(){
		return project;
	}

	public int getTestingType(){
		return testingType;
	}

	public String getStartDate(){
		return startDate;
	}
}