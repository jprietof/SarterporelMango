package co.edu.usa.sarterporelmango.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author jprietof
 *
 */
@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prodruct {
	@Id
	private String reference;
	private String brand;
	private String category;
	private String materiales;
	private String dimensiones;
	private String description;
	private Boolean availability;
	private Double price;
	private Integer quantity;
	private String photography;
}
