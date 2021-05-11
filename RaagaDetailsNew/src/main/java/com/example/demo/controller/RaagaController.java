package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Raaga;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.RaagaService;


@Controller

public class RaagaController {

	@Autowired
	RaagaService service;
	

	
	@RequestMapping("/")
	public String getAllRaags(Model model) {
		//List<Raaga> listofraagas = service.getAllRaagas();
		model.addAttribute("raagas", service.getAllRaagas());
		return "list-raagas";
	}
	
	
	 @RequestMapping(path = {"/edit", "/edit/{id}"})
	    public String editRaagaById(Model model, @PathVariable("id") Optional<Long> id) 
	                            throws RecordNotFoundException 
	    {
	        if (id.isPresent()) {
	            Raaga raaga;
				try {
					raaga = service.getRaagaById(id.get());
					model.addAttribute("raaga", raaga);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
	        } else {
	            model.addAttribute("raaga", new Raaga());
	        }
	        return "add-edit-raaga";
	    }
	
	 @RequestMapping(path = "/delete/{id}")
	    public String deleteRaagaById(Model model, @PathVariable("id") Long id) 
	                            throws RecordNotFoundException 
	    {
	        try {
				service.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "redirect:/";
	    }
	 
	 @RequestMapping(path = "/createRaaga", method = RequestMethod.POST)
	    public String createOrUpdateRaaga(Raaga raaga) 
	    {
	        service.createOrUpdateRaaga(raaga);
	        return "redirect:/";
	    }
	 
	}

