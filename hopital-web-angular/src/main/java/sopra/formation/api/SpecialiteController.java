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

import sopra.hopital.model.Specialite;
import sopra.hopital.repository.SpecialiteRepository;

@RestController
public class SpecialiteController {

	@Autowired
	private SpecialiteRepository speRepo;
	
	@GetMapping("/specialites")
	//@JsonView(Views.Specialite.class)
	public ResponseEntity<List<Specialite>> findAll() {
		return new ResponseEntity<List<Specialite>>(speRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/specialites/{id}")
	//@JsonView(Views.Specialite.class)
	public ResponseEntity<Specialite> findOne(@PathVariable("id") Integer id) {
		Specialite tmp = speRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/specialites")
	//@JsonView(Views.Specialite.class)
	public ResponseEntity<Specialite> create(@RequestBody Specialite obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = speRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/specialites")
	//@JsonView(Views.Specialite.class)
	public ResponseEntity<Specialite> update(@RequestBody Specialite obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = speRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/specialites/{id}")
	//@JsonView(Views.Specialite.class)
	public ResponseEntity<Specialite> delete(@PathVariable("id") Integer id) {
		Specialite tmp = speRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			speRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
