package sopra.hopital.api;

import java.util.*;

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

import sopra.hopital.model.Utilisateur;
import sopra.hopital.model.Views;
import sopra.hopital.repository.UtilisateurRepository;

@RestController
public class UtilisateurController {
	
	
	@Autowired
	private UtilisateurRepository utiRepo;
	
	@GetMapping("/utilisateurs")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<List<Utilisateur>> findAll() {
		return new ResponseEntity<List<Utilisateur>>(utiRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/utilisateurs/{id}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> findOne(@PathVariable("id") Long id) {
		Utilisateur tmp = utiRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/utilisateurs")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> create(@RequestBody Utilisateur obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = utiRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/utilisateurs")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> update(@RequestBody Utilisateur obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = utiRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/utilisateurs/{id}")
	@JsonView(Views.Utilisateur.class)
	public ResponseEntity<Utilisateur> delete(@PathVariable("id") Long id) {
		Utilisateur tmp = utiRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			utiRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	

}
