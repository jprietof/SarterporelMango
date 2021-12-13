package co.edu.usa.sarterporelmango.model.dao;

//import java.util.Date;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.usa.sarterporelmango.model.User;

/**
 * 
 * @author jprietof
 *
 */
public interface IUser extends MongoRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	//List<User> findBybirthDay(Date date);
    Optional<User> findByEmailAndPassword(String email,String password);
    
    /*List<User> findByMonthBirthDay(String monthBirthtDay);*/
}
