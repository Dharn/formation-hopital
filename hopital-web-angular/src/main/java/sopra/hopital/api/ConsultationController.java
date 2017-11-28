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

import sopra.hopital.model.Consultation;
import sopra.hopital.model.Views;
import sopra.hopital.repository.ConsultationRepository;

@RestController
public class ConsultationController {
	
	@Autowired
	private ConsultationRepository consultationRepo;
	
	@GetMapping("/consultations")
	@JsonView(Views.Consultation.class)
	public ResponseEntity<List<Consultation>> findAll() {
		return new ResponseEntity<List<Consultation>>(consultationRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/consultations/{id}")
	@JsonView(Views.Consultation.class)
	public ResponseEntity<Consultation> findOne(@PathVariable("id") Long id) {
		Consultation tmp = consultationRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/consultations")
	@JsonView(Views.Consultation.class)
	public ResponseEntity<Consultation> create(@RequestBody Consultation obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = consultationRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/consultations")
	@JsonView(Views.Consultation.class)
	public ResponseEntity<Consultation> update(@RequestBody Consultation obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = consultationRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/consultations/{id}")
	@JsonView(Views.Consultation.class)
	public ResponseEntity<Consultation> delete(@PathVariable("id") Long id) {
		Consultation tmp = consultationRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			consultationRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
