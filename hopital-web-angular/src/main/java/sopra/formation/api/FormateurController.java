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

import sopra.formation.model.Formateur;
import sopra.formation.model.Views;
import sopra.formation.repository.PersonneRepository;

@RestController
public class FormateurController {

	@Autowired
	private PersonneRepository personneRepo;

	@GetMapping("/formateurs")
	@JsonView(Views.Formateur.class)
	public ResponseEntity<List<Formateur>> findAll() {
		return new ResponseEntity<List<Formateur>>(personneRepo.findAllFormateur(), HttpStatus.OK);
	}

	@GetMapping("/formateurs/{id}")
	@JsonView(Views.FormateurWithEleves.class)
	public ResponseEntity<Formateur> findOne(@PathVariable("id") Long id) {
		Formateur tmp = (Formateur) personneRepo.findOneFormateurWithEleves(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else { 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/formateurs")
	@JsonView(Views.Formateur.class)
	public ResponseEntity<Formateur> create(@RequestBody Formateur obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = personneRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/formateurs")
	@JsonView(Views.Formateur.class)
	public ResponseEntity<Formateur> update(@RequestBody Formateur obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = personneRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/formateurs/{id}")
	@JsonView(Views.Formateur.class)
	public ResponseEntity<Formateur> delete(@PathVariable("id") Long id) {
		Formateur tmp = (Formateur) personneRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personneRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
