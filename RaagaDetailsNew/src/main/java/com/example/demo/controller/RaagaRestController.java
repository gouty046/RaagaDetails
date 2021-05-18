 package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Raaga;
import com.example.demo.repository.RaagaRepository;

@RestController
public class RaagaRestController 
{

	@Autowired
	RaagaRepository repo;
	
//	@GetMapping("raagas")
//similarly if we want to send data from client to server only in xml format using POST we will go with "CONSUME" parameter
	@GetMapping(path="raagas",produces= {"application/xml"})

	public List<Raaga> getAllRaagas(){
		List<Raaga> result = (List<Raaga>) repo.findAll();        
        return result ;
	}

	@GetMapping("raaga/{id}")
	public Optional<Raaga> getRaagaById(@PathVariable("id") long id)   {
		Optional<Raaga> raaga = repo.findById(id);
       
            return raaga;
       }
	
	@PostMapping("raaga")
	public Raaga addRaaga(@RequestBody  Raaga raaga) {
			repo.save(raaga);
			return raaga;
		}
}
