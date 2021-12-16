package co.edu.usa.sarterporelmango;



//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.core.MongoTemplate;

import co.edu.usa.sarterporelmango.model.dao.IOrder;
import co.edu.usa.sarterporelmango.model.dao.IProduct;
import co.edu.usa.sarterporelmango.model.dao.IUser;
//import co.edu.usa.sarterporelmango.repository.RepositoryOrder;
//import co.edu.usa.sarterporelmango.repository.RepositoryUser;

@SpringBootApplication
public class SarterporelmangoApplication implements CommandLineRunner{
	@Autowired
	private IProduct crudRepositoryProduct;
	@Autowired
	private IUser crudRepositoryUser;
	@Autowired 
	private IOrder crudRepositoryOrder;
//	@Autowired
//	private RepositoryOrder orderRepository;
//	private RepositoryUser userRepository;
//	@Autowired
//	private MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(SarterporelmangoApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception{
//		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
//		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		crudRepositoryProduct.deleteAll();
		crudRepositoryOrder.deleteAll();
		crudRepositoryUser.deleteAll();
	}

}
