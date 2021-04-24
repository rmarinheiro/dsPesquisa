package br.com.rafael.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafael.dspesquisa.dto.GameDTO;
import br.com.rafael.dspesquisa.entities.Game;
import br.com.rafael.dspesquisa.repositories.GameRepository;
import br.com.rafael.dspesquisa.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameResource {
	
	@Autowired
	private GameService service;
	
	
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){
		List<GameDTO> game = service.findAll();
		return ResponseEntity.ok().body(game);
	}
	


}
