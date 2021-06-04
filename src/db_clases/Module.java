package db_clases;

import java.util.ArrayList;

public class Module {
	
	private String code;
	private String name;
	private String max_hours;
	private String min_hours;
	private String inital_date;
	private String final_date;
	
	private ArrayList <Unit> UnitList = new ArrayList<Unit>();
	
		
	public Module() {
		super();
	}
	
	public Module(String code, String name, String max_hours, String min_hours, String inital_date, String final_date, ArrayList<Unit> uList) {
		super();
		this.code = code;
		this.name = name;
		this.max_hours = max_hours;
		this.min_hours = min_hours;
		this.inital_date = inital_date;
		this.final_date = final_date;
		UnitList = uList;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMax_hours() {
		return max_hours;
	}

	public void setMax_hours(String max_hours) {
		this.max_hours = max_hours;
	}

	public String getMin_hours() {
		return min_hours;
	}

	public void setMin_hours(String min_hours) {
		this.min_hours = min_hours;
	}

	public String getInital_date() {
		return inital_date;
	}

	public void setInital_date(String inital_date) {
		this.inital_date = inital_date;
	}

	public String getFinal_date() {
		return final_date;
	}

	public void setFinal_date(String final_date) {
		this.final_date = final_date;
	}

	public ArrayList<Unit> getUnitList() {
		return UnitList;
	}

	public void setUnitList(ArrayList<Unit> unitList) {
		UnitList = unitList;
	}

	@Override
	public String toString() {
		return "{\"codi_modul\":\"" + code + "\", \"nom_modul\":\"" + name + "\", \"durada_min_modul\":\"" + min_hours + "\", \"durada_max_modul\":\"" + max_hours + "\", " + "\"data_inici_modul\":\"" + inital_date + "\", " + "\"data_fi_modul\":\"" + final_date + "\", \"unitats\":" + UnitList + "}";
	}


}
