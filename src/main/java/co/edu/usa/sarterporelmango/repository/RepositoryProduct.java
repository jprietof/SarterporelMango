package co.edu.usa.sarterporelmango.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.sarterporelmango.model.Product;
import co.edu.usa.sarterporelmango.model.dao.IProduct;

import java.util.*;
/**
 * 
 * @author jprietof
 *
 */
@Repository
public class RepositoryProduct {
	@Autowired
	private IProduct productCrudRepository;
	
	public List<Product> getAll(){
		return productCrudRepository.findAll();
	}
	
	public Optional<Product> getProduct(String reference){
		return productCrudRepository.findById(reference);
	}
	
	public Product create(Product product){
		return productCrudRepository.save(product);
	}
	
	public void update(Product product){
		productCrudRepository.save(product);
	}
	
	public void delete(Product product){
		productCrudRepository.delete(product);
	}
}
