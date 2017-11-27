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

import sopra.formation.model.Module;
import sopra.formation.model.Views;
import sopra.formation.repository.ModuleRepository;

@RestController
public class ModuleController {

	@Autowired
	private ModuleRepository moduleRepo;

	@GetMapping("/modules")
	@JsonView(Views.ModuleWithFormations.class)
	public ResponseEntity<List<Module>> findAll() {
		return new ResponseEntity<List<Module>>(moduleRepo.findAllWithFormation(), HttpStatus.OK);
	}

	@GetMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> findOne(@PathVariable("id") Long id) {
		Module tmp = moduleRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> create(@RequestBody Module module) {
		if (module.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		module = moduleRepo.save(module);

		return new ResponseEntity<Module>(module, HttpStatus.CREATED);
	}

	@PutMapping("/modules")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> update(@RequestBody Module module) {
		if (module.getId() == null) {
			return create(module);
		}
		module = moduleRepo.save(module);

		return new ResponseEntity<Module>(module, HttpStatus.OK);
	}

	@DeleteMapping("/modules/{id}")
	@JsonView(Views.Module.class)
	public ResponseEntity<Module> delete(@PathVariable("id") Long id) {
		Module tmp = moduleRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			moduleRepo.delete(id);
			return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
		}
	}
}
