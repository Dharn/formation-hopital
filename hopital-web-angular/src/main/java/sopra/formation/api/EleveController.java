package sopra.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Eleve;
import sopra.formation.model.Views;
import sopra.formation.repository.PersonneRepository;

@RestController
public class EleveController {

	@Autowired
	private PersonneRepository personneRepo;

	@GetMapping("/eleves")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<List<Eleve>> findAll() {
		return new ResponseEntity<List<Eleve>>(personneRepo.findAllEleve(), HttpStatus.OK);
	}
	
	@GetMapping("/elevesWithoutRessource/{id}")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<List<Eleve>> findAllWithoutRessourceAndEleve(@PathVariable Long id) {
		Eleve tmp = (Eleve) personneRepo.findOne(id);
		return new ResponseEntity<List<Eleve>>(personneRepo.findAllEleveWithoutRessource(tmp), HttpStatus.OK);
	}
	
	@GetMapping("/elevesWithoutRessource/")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<List<Eleve>> findAllWithoutRessource() {
		return new ResponseEntity<List<Eleve>>(personneRepo.findAllEleveWithoutRessource(null), HttpStatus.OK);
	}

	@GetMapping("/eleves/{id}")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<Eleve> findOne(@PathVariable("id") Long id) {
		Eleve tmp = (Eleve) personneRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/eleves")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<Eleve> create(@RequestBody Eleve obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = personneRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/eleves")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<Eleve> update(@RequestBody Eleve obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = personneRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/eleves/{id}")
	@JsonView(Views.Eleve.class)
	public ResponseEntity<Eleve> delete(@PathVariable("id") Long id) {
		Eleve tmp = (Eleve) personneRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personneRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
