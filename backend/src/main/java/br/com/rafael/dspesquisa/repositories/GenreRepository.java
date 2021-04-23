package br.com.rafael.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.dspesquisa.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
