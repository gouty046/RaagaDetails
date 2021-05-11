package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Raaga;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.RaagaRepository;



@Service
public class RaagaService {
	
	
	@Autowired
	private RaagaRepository repo;
	
	
	public List<Raaga> getAllRaagas(){
		List<Raaga> result = (List<Raaga>) repo.findAll();
        
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Raaga>();
        }
	}

	public void save(Raaga raaga) {
		repo.save(raaga);
	}
	
	public Raaga getRaagaById(long id) throws Exception  {
		Optional<Raaga> raaga = repo.findById(id);
        System.out.println("raaag.get---> "+raaga.get());
        if(raaga.isPresent()) {
            return raaga.get();
        } else {
            throw new RecordNotFoundException("No raaga record exist for given id");
        }
      }
	
	public Raaga createOrUpdateRaaga(Raaga raaga) 
    {
        if(raaga.getId()  == null) 
        {
            raaga = repo.save(raaga);  
            return raaga;
        } 
        else
        {
            Optional<Raaga> raaga2 = repo.findById(raaga.getId());
             
            if(raaga2.isPresent()) 
            {
            	Raaga newRaaga = raaga2.get();
                newRaaga.setRaaganame(raaga.getRaaganame());
                newRaaga.setRaagatiming(raaga.getRaagatiming());
                newRaaga.setRaagaarohana(raaga.getRaagaarohana());
                newRaaga.setRaagaavarohana(raaga.getRaagaavarohana());
                newRaaga = repo.save(newRaaga);
                 
                return newRaaga;
                
            } else {
                raaga = repo.save(raaga);
                 
                return raaga;
            }
        }
    } 
	
	
	public void delete(long id) throws Exception{
		 Optional<Raaga> raaga = repo.findById(id);
         
	        if(raaga.isPresent()) 
	        {
	            repo.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No raaga record exist for given id");
	        }	}
}
