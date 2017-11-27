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

import sopra.formation.model.Ressource;
import sopra.formation.model.RessourceId;
import sopra.formation.model.Type;
import sopra.formation.model.Views;
import sopra.formation.repository.RessourceRepository;

@RestController
public class RessourceController {

	@Autowired
	private RessourceRepository ressourceRepo;

	@GetMapping("/ressources")
	@JsonView(Views.Ressource.class)
	public ResponseEntity<List<Ressource>> findAll() {
		return new ResponseEntity<List<Ressource>>(ressourceRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/ressources/{type}:{code}")
	@JsonView(Views.Ressource.class)
	public ResponseEntity<Ressource> findOne(@PathVariable Type type, @PathVariable String code) {
		Ressource tmp = (Ressource) ressourceRepo.findOne(new RessourceId(type, code));
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/ressources")
	@JsonView(Views.Ressource.class)
	public ResponseEntity<Ressource> create(@RequestBody Ressource obj) {
		obj = ressourceRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/ressources")
	@JsonView(Views.Ressource.class)
	public ResponseEntity<Ressource> update(@RequestBody Ressource obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = ressourceRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/ressources/{type}:{code}")
	@JsonView(Views.Ressource.class)
	public ResponseEntity<Ressource> delete(@PathVariable Type type, @PathVariable String code) {
		Ressource tmp = (Ressource) ressourceRepo.findOne(new RessourceId(type, code));
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			ressourceRepo.delete(new RessourceId(type, code));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/types")
	public ResponseEntity<Type[]> findAllType() {
		return new ResponseEntity<>(Type.values(), HttpStatus.OK);
	}
}
