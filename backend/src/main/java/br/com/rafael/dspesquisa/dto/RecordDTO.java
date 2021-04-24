package br.com.rafael.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.rafael.dspesquisa.entities.Record;
import br.com.rafael.dspesquisa.entities.enums.Plataform;

public class RecordDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Instant moment;
	private String name;
	private Integer age;
	private String gameTitle;
	private Plataform plataform;
	private String genreName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGameTitle() {
		return gameTitle;
	}
	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	public Plataform getPlataform() {
		return plataform;
	}
	public void setPlataform(Plataform plataform) {
		this.plataform = plataform;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	public RecordDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RecordDTO(Record entity) {
		 id = entity.getId();
		 moment = entity.getMoment();
		 name = entity.getName();
		 age = entity.getAge();
		 gameTitle = entity.getGame().getTitle();
		 plataform = entity.getGame().getPlataform();
		 genreName = entity.getGame().getGenre().getName();
	}
	

}
