package co.edu.usa.sarterporelmango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import co.edu.usa.sarterporelmango.model.Product;
import co.edu.usa.sarterporelmango.service.ServiceProduct;

/**
 * 
 * @author jprietof
 *
 */
@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class ControllerProduct {
	@Autowired
	private ServiceProduct accesoryService;
	
	@GetMapping("/all")
	public List<Product> getAll(){
		return accesoryService.getAll();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product gadget) {
		return accesoryService.create(gadget);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product gadget) {
		return accesoryService.update(gadget);
	}
	
	@GetMapping("/{reference}")
	public Optional<Product> getCook(@PathVariable("reference") String reference){
		return accesoryService.getCook(reference);
	}
	
	@DeleteMapping("{reference}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("reference") String reference) {
		return accesoryService.delete(reference);
	}
}
