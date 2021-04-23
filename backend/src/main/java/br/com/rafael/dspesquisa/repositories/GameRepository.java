package br.com.rafael.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.dspesquisa.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
