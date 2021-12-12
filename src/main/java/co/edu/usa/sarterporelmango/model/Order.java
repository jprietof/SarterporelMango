package co.edu.usa.sarterporelmango.model;

import java.util.Date;
import java.util.Map;

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
@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	public static String PEDING = "Pendiente";
	public static String APROVED = "Aprobada";
	public static String REJECTED = "Rechazada";
	
	@Id
	private Integer id;
	private Date registerDay;
	private String satus;
	private User salesMan;
	private Map<String, Product> products;
	private Map<String, Integer> quantities;
}
