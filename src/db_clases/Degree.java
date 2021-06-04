package db_clases;

import java.util.ArrayList;

public class Degree {
	
	private String code_degree;
	private String name;
	private String adap_curr;
	private String hours_duration;
	private String initial_date;
	private String final_date;
	
	private ArrayList <Module> ModuleList = new ArrayList <Module>();
	
	
	public Degree() {
		super();
	}
	
	public Degree(String name, ArrayList <Module> moduleList) {
		super();
		this.name = name;
		ModuleList = moduleList;
	}
	
	public Degree(String code_degree, String name, String adap_curr, String hours_duration, String initial_date, String final_date, ArrayList <Module> moduleList) {
		super();
		this.code_degree = code_degree;
		this.name = name;
		this.adap_curr = adap_curr;
		this.hours_duration = hours_duration;
		this.initial_date = initial_date;
		this.final_date = final_date;
		ModuleList = moduleList;
	}

	public String getCode_degree() {
		return code_degree;
	}

	public void setCode_degree(String code_degree) {
		this.code_degree = code_degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdap_curr() {
		return adap_curr;
	}

	public void setAdap_curr(String adap_curr) {
		this.adap_curr = adap_curr;
	}

	public String getHours_duration() {
		return hours_duration;
	}

	public void setHours_duration(String hours_duration) {
		this.hours_duration = hours_duration;
	}

	public String getInitial_date() {
		return initial_date;
	}

	public void setInitial_date(String initial_date) {
		this.initial_date = initial_date;
	}

	public String getFinal_date() {
		return final_date;
	}

	public void setFinal_date(String final_date) {
		this.final_date = final_date;
	}

	public ArrayList<Module> getModuleList() {
		return ModuleList;
	}

	public void setModuleList(ArrayList<Module> moduleList) {
		ModuleList = moduleList;
	}

	@Override
	public String toString() {
		return "{\"codi_cicle_formatiu\":\"" + code_degree + "\", \"nom_cicle_formatiu\":\"" + name + "\", \"codi_adaptacio_curricular\":\"" + adap_curr
				+ "\", \"hores_cicle_formatiu\":\"" + hours_duration + "\", \"data_inici_cicle_formatiu\":\"" + initial_date + "\", \"data_fi_cicle_formatiu\":\"" + final_date
				+ "\", \"moduls\":" + ModuleList + "}";
	}
	
	
	

}
