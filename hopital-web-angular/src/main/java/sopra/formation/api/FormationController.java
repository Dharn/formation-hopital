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

import sopra.formation.model.Formation;
import sopra.formation.model.Views;
import sopra.formation.repository.FormationRepository;

@RestController
public class FormationController {

	@Autowired
	private FormationRepository formationRepo;

	@GetMapping("/formations")
	@JsonView(Views.FormationWithModules.class)
	public ResponseEntity<List<Formation>> findAll() {
		return new ResponseEntity<List<Formation>>(formationRepo.findAllWithModules(), HttpStatus.OK);
	}

	@GetMapping("/formations/{id}")
	@JsonView(Views.Formation.class)
	public ResponseEntity<Formation> findOne(@PathVariable("id") Long id) {
		Formation tmp = formationRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/formations")
	@JsonView(Views.Formation.class)
	public ResponseEntity<Formation> create(@RequestBody Formation formation) {
		if (formation.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		formation = formationRepo.save(formation);

		return new ResponseEntity<>(formation, HttpStatus.CREATED);
	}

	@PutMapping("/formations")
	@JsonView(Views.Formation.class)
	public ResponseEntity<Formation> update(@RequestBody Formation formation) {
		if (formation.getId() == null) {
			return create(formation);
		}
		formation = formationRepo.save(formation);

		return new ResponseEntity<>(formation, HttpStatus.OK);
	}

	@DeleteMapping("/formations/{id}")
	@JsonView(Views.Formation.class)
	public ResponseEntity<Formation> delete(@PathVariable("id") Long id) {
		Formation tmp = formationRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			formationRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
