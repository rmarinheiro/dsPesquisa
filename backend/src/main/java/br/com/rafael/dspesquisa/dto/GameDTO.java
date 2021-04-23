package br.com.rafael.dspesquisa.dto;

import java.io.Serializable;

import br.com.rafael.dspesquisa.entities.Game;
import br.com.rafael.dspesquisa.entities.enums.Plataform;

public class GameDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Plataform plataform;
	
	public GameDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Plataform getPlataform() {
		return plataform;
	}

	public void setPlataform(Plataform plataform) {
		this.plataform = plataform;
	}

	public GameDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		plataform = entity.getPlataform();
	}
	
	

}
