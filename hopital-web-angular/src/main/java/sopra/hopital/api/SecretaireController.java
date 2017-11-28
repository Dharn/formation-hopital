package sopra.hopital.api;

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

import sopra.hopital.model.Secretaire;
import sopra.hopital.repository.SecretaireRepository;

@RestController
public class SecretaireController {
	
	@Autowired
	private SecretaireRepository secretaireRepo;
	
	@GetMapping("/secretaires") 
	//@JsonView(Views.Secretaire.class)
	public ResponseEntity<List<Secretaire>> findAll() {
		return new ResponseEntity<List<Secretaire>>(secretaireRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/secretaires/{id}")
	//@JsonView(Views.Secretaire.class)
	public ResponseEntity<Secretaire> findOne(@PathVariable("id") Long id) {
		Secretaire tmp = secretaireRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/secretaires")
	//@JsonView(Views.Secretaire.class)
	public ResponseEntity<Secretaire> create(@RequestBody Secretaire obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = secretaireRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/secretaires")
	//@JsonView(Views.Secretaire.class)
	public ResponseEntity<Secretaire> update(@RequestBody Secretaire obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = secretaireRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/secretaires/{id}")
	//@JsonView(Views.Secretaire.class)
	public ResponseEntity<Secretaire> delete(@PathVariable("id") Long id) {
		Secretaire tmp = secretaireRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			secretaireRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	

}
