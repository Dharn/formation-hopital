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

import sopra.hopital.model.Salle;
import sopra.hopital.repository.SalleRepository;

@RestController
public class SalleController {

	@Autowired
	private SalleRepository salleRepo;
	
	@GetMapping("/salles")
	//@JsonView(Views.Salle.class)
	public ResponseEntity<List<Salle>> findAll() {
		return new ResponseEntity<List<Salle>>(salleRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/salles/{id}")
	//@JsonView(Views.Salle.class)
	public ResponseEntity<Salle> findOne(@PathVariable("id") Long id) {
		Salle tmp = salleRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/salles")
	//@JsonView(Views.Salle.class)
	public ResponseEntity<Salle> create(@RequestBody Salle obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = salleRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping("/salles")
	//@JsonView(Views.Salle.class)
	public ResponseEntity<Salle> update(@RequestBody Salle obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = salleRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/salles/{id}")
	//@JsonView(Views.Salle.class)
	public ResponseEntity<Salle> delete(@PathVariable("id") Long id) {
		Salle tmp = salleRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			salleRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
