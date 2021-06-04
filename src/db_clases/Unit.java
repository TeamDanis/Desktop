package db_clases;

public class Unit {
	
	private String code;
	private String name;
	private String duration;
	private String ind_fct;
	private String ind_synthesis;
	private String ind_language;
	private String ind_project;

	
	
	public Unit() {
		super();
	}
	
	public Unit (String name) {
		super();
		name = name;
	}
	
	public Unit (String code, String name, String duration, String ind_fct, String ind_synthesis, String ind_language, String ind_project) {
		super();
		this.code = code;
		this.name = name;
		this.duration = duration;
		this.ind_fct = ind_fct;
		this.ind_synthesis = ind_synthesis;
		this.ind_language = ind_language;
		this.ind_project = ind_project;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInd_fct() {
		return ind_fct;
	}

	public void setInd_fct(String ind_fct) {
		this.ind_fct = ind_fct;
	}

	public String getInd_synthesis() {
		return ind_synthesis;
	}

	public void setInd_synthesis(String ind_synthesis) {
		this.ind_synthesis = ind_synthesis;
	}

	public String getInd_language() {
		return ind_language;
	}

	public void setInd_language(String ind_language) {
		this.ind_language = ind_language;
	}

	public String getInd_project() {
		return ind_project;
	}

	public void setInd_project(String ind_project) {
		this.ind_project = ind_project;
	}

	@Override
	public String toString() {
		return "{\"codi_unitat_formativa\":\"" + code + "\", \"nom_unitat_formativa\":\"" + name + "\", \"durada_unitat_formativa\":\"" + duration + "\", \"indicador_fct\":\"" + ind_fct + "\",\"indicador_sintesis\":\""
				+ ind_synthesis + "\", \"indicador_idioma\":\"" + ind_language + "\", \"indicador_projecte\":\"" + ind_project + "\"}";
	}
	

}
