package POJO;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Login {

	@SerializedName("key_skills")
	private List<Integer> keySkills;

	@SerializedName("on_part_time")
	private boolean onPartTime;

	@SerializedName("gender")
	private String gender;

	@SerializedName("employee_sick_leaves_unofficial")
	private List<EmployeeSickLeavesUnofficialItem> employeeSickLeavesUnofficial;

	@SerializedName("employee_vacation_requests")
	private List<EmployeeVacationRequestsItem> employeeVacationRequests;

	@SerializedName("surname")
	private String surname;

	@SerializedName("maternity")
	private boolean maternity;

	@SerializedName("employee_family")
	private List<EmployeeFamilyItem> employeeFamily;

	@SerializedName("employee_achievements")
	private List<EmployeeAchievementsItem> employeeAchievements;

	@SerializedName("joining_date")
	private String joiningDate;

	@SerializedName("courses")
	private String courses;

	@SerializedName("employee_position_grades")
	private List<EmployeePositionGradesItem> employeePositionGrades;

	@SerializedName("employee_projects")
	private List<EmployeeProjectsItem> employeeProjects;

//	@SerializedName("employee_cities")
//	private List<EmployeeCitiesItem> employeeCities;

	@SerializedName("is_active")
	private boolean isActive;

	@SerializedName("citizenship")
	private Citizenship citizenship;

	@SerializedName("employee_languages")
	private List<EmployeeLanguagesItem> employeeLanguages;

	@SerializedName("birth")
	private String birth;

	@SerializedName("employee_civil_contracts")
	private List<EmployeeCivilContractsItem> employeeCivilContracts;

	@SerializedName("qualification_skills")
	private List<Integer> qualificationSkills;

	@SerializedName("internal_email")
	private String internalEmail;

	@SerializedName("patronymic")
	private String patronymic;

	@SerializedName("employee_educations")
	private List<EmployeeEducationsItem> employeeEducations;

	@SerializedName("certificates")
	private String certificates;

	@SerializedName("employee_project_salary_rates")
	private List<EmployeeProjectSalaryRatesItem> employeeProjectSalaryRates;

	@SerializedName("employee_sick_leaves_official")
	private List<EmployeeSickLeavesOfficialItem> employeeSickLeavesOfficial;

	@SerializedName("phone")
	private String phone;

	@SerializedName("employee_actual_vacations")
	private List<EmployeeActualVacationsItem> employeeActualVacations;

//	@SerializedName("employee_positions")u

	@SerializedName("name")
	private String name;

	@SerializedName("employee_previous_experience")
	private List<EmployeePreviousExperienceItem> employeePreviousExperience;

	public List<Integer> getKeySkills(){
		return keySkills;
	}

	public boolean isOnPartTime(){
		return onPartTime;
	}

	public String getGender(){
		return gender;
	}

	public List<EmployeeSickLeavesUnofficialItem> getEmployeeSickLeavesUnofficial(){
		return employeeSickLeavesUnofficial;
	}

	public List<EmployeeVacationRequestsItem> getEmployeeVacationRequests(){
		return employeeVacationRequests;
	}

	public String getSurname(){
		return surname;
	}

	public boolean isMaternity(){
		return maternity;
	}

	public List<EmployeeFamilyItem> getEmployeeFamily(){
		return employeeFamily;
	}

	public List<EmployeeAchievementsItem> getEmployeeAchievements(){
		return employeeAchievements;
	}

	public String getJoiningDate(){
		return joiningDate;
	}

	public String getCourses(){
		return courses;
	}

	public List<EmployeePositionGradesItem> getEmployeePositionGrades(){
		return employeePositionGrades;
	}

	public List<EmployeeProjectsItem> getEmployeeProjects(){
		return employeeProjects;
	}

//	public List<EmployeeCitiesItem> getEmployeeCities(){
//		return employeeCities;
//	}

	public boolean isIsActive(){
		return isActive;
	}

	public Citizenship getCitizenship(){
		return citizenship;
	}

	public List<EmployeeLanguagesItem> getEmployeeLanguages(){
		return employeeLanguages;
	}

	public String getBirth(){
		return birth;
	}

	public List<EmployeeCivilContractsItem> getEmployeeCivilContracts(){
		return employeeCivilContracts;
	}

	public List<Integer> getQualificationSkills(){
		return qualificationSkills;
	}

	public String getInternalEmail(){
		return internalEmail;
	}

	public String getPatronymic(){
		return patronymic;
	}

	public List<EmployeeEducationsItem> getEmployeeEducations(){
		return employeeEducations;
	}

	public String getCertificates(){
		return certificates;
	}

	public List<EmployeeProjectSalaryRatesItem> getEmployeeProjectSalaryRates(){
		return employeeProjectSalaryRates;
	}

	public List<EmployeeSickLeavesOfficialItem> getEmployeeSickLeavesOfficial(){
		return employeeSickLeavesOfficial;
	}

	public String getPhone(){
		return phone;
	}

	public List<EmployeeActualVacationsItem> getEmployeeActualVacations(){
		return employeeActualVacations;
	}

//	public List<EmployeePositionsItem> getEmployeePositions(){
//		return employeePositions;
//	}

	public String getName(){
		return name;
	}

	public List<EmployeePreviousExperienceItem> getEmployeePreviousExperience(){
		return employeePreviousExperience;
	}
}