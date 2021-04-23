package br.com.rafael.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.rafael.dspesquisa.entities.enums.Plataform;

@Entity
@Table(name = "tbl_game")
public class Game implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private Plataform plataform;
	
	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "game")
	private List<Record> record = new ArrayList<Record>();
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(Long id, String title, Plataform plataform, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.plataform = plataform;
		this.genre = genre;
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Record> getRecord() {
		return record;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
