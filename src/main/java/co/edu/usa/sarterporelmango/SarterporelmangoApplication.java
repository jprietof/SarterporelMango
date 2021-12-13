package co.edu.usa.sarterporelmango;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.usa.sarterporelmango.model.dao.IOrder;
import co.edu.usa.sarterporelmango.model.dao.IProduct;
import co.edu.usa.sarterporelmango.model.dao.IUser;

@SpringBootApplication
public class SarterporelmangoApplication implements CommandLineRunner{
	@Autowired
	private IProduct crudRepositoryProduct;
	@Autowired
	private IUser crudRepositoryUser;
	@Autowired 
	private IOrder crudRepositoryOrder;
//	@Autowired
//	private MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(SarterporelmangoApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception{
/*		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyy-MM-dd");*/
		crudRepositoryProduct.deleteAll();
		crudRepositoryOrder.deleteAll();
		crudRepositoryUser.deleteAll();
	}

}
