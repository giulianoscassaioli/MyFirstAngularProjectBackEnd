package com.angular.controller;

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

import com.angular.ImpiegatoService;
import com.angular.exception.ImpiegatoNonTrovatoException;
import com.angular.model.Impiegato;

@RestController
public class ImpiegatoController {

	@Autowired
	ImpiegatoService service;

	@PostMapping("/impiegato")
	public ResponseEntity<Impiegato> saveImpiegato(@RequestBody Impiegato i) {

		return new ResponseEntity<>(service.saveImpiegato(i), HttpStatus.CREATED);
	}

	@GetMapping("/impiegato")
	public ResponseEntity<List<Impiegato>> allImpiegato() {

		return new ResponseEntity<>(service.allImpiegati(), HttpStatus.OK);
	}

	@GetMapping("/impiegato/{id}")
	public ResponseEntity<?> impiegatoById(@PathVariable Long id) {

		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (ImpiegatoNonTrovatoException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("/impiegato/{id}")
	public ResponseEntity<?> delteImpiegatoById(@PathVariable Long id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PutMapping("/impiegato")
	public ResponseEntity<Impiegato> updateImpiegato(@RequestBody Impiegato i) {

		return new ResponseEntity<>(service.updateImpiegato(i), HttpStatus.OK);
	}

}
