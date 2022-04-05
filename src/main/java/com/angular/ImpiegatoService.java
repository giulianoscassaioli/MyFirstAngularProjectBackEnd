package com.angular;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.exception.ImpiegatoNonTrovatoException;
import com.angular.model.Impiegato;
import com.angular.repository.ImpiegatoRepository;

@Service
public class ImpiegatoService {
	
	@Autowired
	ImpiegatoRepository repo;
	
	public Impiegato saveImpiegato( Impiegato i ) {
		i.setCodiceImpiegato(UUID.randomUUID().toString()); //per generare un id random
		return repo.save(i);
	}
	
	public List<Impiegato> allImpiegati( ) {
		
		return repo.findAll();
	}
	
	public Impiegato updateImpiegato( Impiegato i ) {
		return repo.save(i);
	}
	
	public void deleteEmployee( Long id) {
		
		repo.deleteById(id);
	}
	
	public Impiegato findById( Long id) throws ImpiegatoNonTrovatoException {
		
		return repo.findById(id)
				.orElseThrow(() -> 
				new ImpiegatoNonTrovatoException(" L'utente con id "+id+" non è stato trovato!"));
	}
	

}
