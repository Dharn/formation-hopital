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

import sopra.hopital.model.Patient;
import sopra.hopital.model.Specialite;
import sopra.hopital.repository.PatientRepository;
import sopra.hopital.repository.SpecialiteRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("/patients")
	//@JsonView(Views.Patient.class)
	public ResponseEntity<List<Patient>> findAll() {
		return new ResponseEntity<List<Patient>>(patientRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/patients/{id}")
	//@JsonView(Views.Patient.class)
	public ResponseEntity<Patient> findOne(@PathVariable("id") Long id) {
		Patient tmp = patientRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/patients")
	//@JsonView(Views.Patient.class)
	public ResponseEntity<Patient> create(@RequestBody Patient obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = patientRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/patients")
	//@JsonView(Views.Patient.class)
	public ResponseEntity<Patient> update(@RequestBody Patient obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = patientRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/patients/{id}")
	//@JsonView(Views.Patient.class)
	public ResponseEntity<Patient> delete(@PathVariable("id") Long id) {
		Patient tmp = patientRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			patientRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
