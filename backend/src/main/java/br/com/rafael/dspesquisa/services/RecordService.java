package br.com.rafael.dspesquisa.services;



import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rafael.dspesquisa.dto.RecordDTO;
import br.com.rafael.dspesquisa.dto.RecordInsertDTO;
import br.com.rafael.dspesquisa.entities.Game;
import br.com.rafael.dspesquisa.entities.Record;
import br.com.rafael.dspesquisa.repositories.GameRepository;
import br.com.rafael.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();
		
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		Game game = gameRepository.getOne(dto.getGameId());
		
		entity.setGame(game);
		
		recordRepository.save(entity);
		
		return new RecordDTO(entity);
		
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return recordRepository.findByMoments(minDate,maxDate,pageRequest).map(x -> new RecordDTO(x));
	}

	
}
