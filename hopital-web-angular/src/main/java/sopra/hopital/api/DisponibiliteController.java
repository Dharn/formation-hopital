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

import com.fasterxml.jackson.annotation.JsonView;

import sopra.hopital.model.Disponibilite;
import sopra.hopital.model.Views;
import sopra.hopital.repository.DisponibiliteRepository;

@RestController
public class DisponibiliteController {


	@Autowired
	private DisponibiliteRepository dispoRepo;
	
	
	@GetMapping("/disponibilites")
	@JsonView(Views.Disponibilite.class)
	public ResponseEntity<List<Disponibilite>> findAll() {
		return new ResponseEntity<List<Disponibilite>>(dispoRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/disponibilites/{id}")
	@JsonView(Views.Disponibilite.class)
	public ResponseEntity<Disponibilite> findOne(@PathVariable("id") Long id) {
		Disponibilite tmp = dispoRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/disponibilites")
	@JsonView(Views.Disponibilite.class)
	public ResponseEntity<Disponibilite> create(@RequestBody Disponibilite obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = dispoRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/disponibilites")
	@JsonView(Views.Disponibilite.class)
	public ResponseEntity<Disponibilite> update(@RequestBody Disponibilite obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = dispoRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/disponibilites/{id}")
	@JsonView(Views.Disponibilite.class)
	public ResponseEntity<Disponibilite> delete(@PathVariable("id") Long id) {
		Disponibilite tmp = dispoRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			dispoRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}
