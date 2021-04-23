package br.com.rafael.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
