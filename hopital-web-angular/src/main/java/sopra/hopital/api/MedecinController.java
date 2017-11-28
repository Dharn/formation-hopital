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

import sopra.hopital.model.Medecin;
import sopra.hopital.model.Views;
import sopra.hopital.repository.MedecinRepository;

@RestController
public class MedecinController {
	
	@Autowired
	private MedecinRepository medRepo;
	
	@GetMapping("/medecins")
	@JsonView(Views.Medecin.class)
	public ResponseEntity<List<Medecin>> findAll() {
		return new ResponseEntity<List<Medecin>>(medRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/medecins/{id}")
	@JsonView(Views.Medecin.class)
	public ResponseEntity<Medecin> findOne(@PathVariable("id") Long id) {
		Medecin tmp = medRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/medecins")
	@JsonView(Views.Medecin.class)
	public ResponseEntity<Medecin> create(@RequestBody Medecin obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = medRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/medecins")
	@JsonView(Views.Medecin.class)
	public ResponseEntity<Medecin> update(@RequestBody Medecin obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = medRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/medecins/{id}")
	@JsonView(Views.Medecin.class)
	public ResponseEntity<Medecin> delete(@PathVariable("id") Long id) {
		Medecin tmp = medRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			medRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
