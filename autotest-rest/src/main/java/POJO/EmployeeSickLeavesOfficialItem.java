package POJO;

import com.google.gson.annotations.SerializedName;

public class EmployeeSickLeavesOfficialItem{

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("notes_number")
	private String notesNumber;

	@SerializedName("start_date")
	private String startDate;

	public String getEndDate(){
		return endDate;
	}

	public String getNotesNumber(){
		return notesNumber;
	}

	public String getStartDate(){
		return startDate;
	}
}