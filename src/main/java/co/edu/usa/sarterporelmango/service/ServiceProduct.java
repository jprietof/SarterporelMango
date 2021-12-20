package co.edu.usa.sarterporelmango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.sarterporelmango.model.Product;
import co.edu.usa.sarterporelmango.repository.RepositoryProduct;
import java.util.*;

/**
 * 
 * @author jprietof
 *
 */
@Service
public class ServiceProduct {
	@Autowired
	private RepositoryProduct cookRepository;
	
	public List<Product> getAll(){
		return cookRepository.getAll();
	}
	
	public Optional<Product> getCook(String reference){
		return cookRepository.getProduct(reference);
	}
	
	public Product create(Product accesory) {
		if(accesory.getReference()==null) {
			return accesory;
		}else{
			return cookRepository.create(accesory);
		}
	}
	
	public Product update(Product accesory) {
		if(accesory.getReference() !=null) {
			Optional<Product> accesoryDb = cookRepository.getProduct(accesory.getReference());
			if(!accesoryDb.isEmpty()) {
				if(accesory.getBrand() !=null) {
					accesoryDb.get().setBrand(accesory.getBrand());
				}
				if(accesory.getCategory() !=null) {
					accesoryDb.get().setCategory(accesory.getCategory());
				}
				if(accesory.getDescription() !=null) {
					accesoryDb.get().setDescription(accesory.getDescription());;
				}
				if(accesory.getDimensiones() !=null) {
					accesoryDb.get().setDimensiones(accesory.getDimensiones());
				}
				if(accesory.getMateriales() !=null) {
					accesoryDb.get().setMateriales(accesory.getMateriales());
				}
				if(accesory.getPrice() !=0.0) {
					accesoryDb.get().setPrice(accesory.getPrice());
				}
				if(accesory.getQuantity() !=0) {
					accesoryDb.get().setQuantity(accesory.getQuantity());
				}
				if(accesory.getPhotography() !=null) {
					accesoryDb.get().setPhotography(accesory.getPhotography());
				}
				accesoryDb.get().setAvailability(accesory.getAvailability());
				cookRepository.update(accesoryDb.get());
				return accesoryDb.get();
			}else {
				return accesory;
			}
		}else {
			return accesory;
		}
	}
	
	public boolean delete(String reference) {
		Boolean aBoolean = getCook(reference).map(accesory->{
			cookRepository.delete(accesory);
			return true;
		}).orElse(false);
		return aBoolean;
	}
	
	//Reto 5
	public List<Product> productByPrice(double price){
		return cookRepository.productByPrice(price);
	}
	
	public List<Product> findByDescriptionLike(String description){
		return cookRepository.findByDescriptionLike(description);
	}
}
