package co.edu.usa.sarterporelmango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.sarterporelmango.model.User;
import co.edu.usa.sarterporelmango.repository.RepositoryUser;
import java.util.*;

/**
 * 
 * @author jprietof
 *
 */
@Service
public class ServiceUser {
	@Autowired
	private RepositoryUser userRepository;
	
	public List<User> getAll(){
		return userRepository.getAll();
	}
	
	public Optional<User> getUser(int id){
		return userRepository.getUser(id);
	}
	
	public User create(User user) {
		if(user.getId() == null) {
			return user;
		}else {
			Optional<User> e = userRepository.getUser(user.getId());
			if(e.isEmpty()) {
				if(existeEmail(user.getEmail())==false) {
					return userRepository.create(user);
				}else {
					return user;
				}
			}else {
				return user;
			}
		}
	}
	
	public boolean existeEmail(String email) {
		return userRepository.existeEmail(email);
	}
	
	public User update(User user) {
		if(user.getId() !=null) {
			Optional<User> userDb = userRepository.getUser(user.getId());
			if(!userDb.isEmpty()) {
				if(user.getIdentification() !=null) {
					userDb.get().setIdentification(user.getIdentification());
				}
				if(user.getName() !=null) {
					userDb.get().setName(user.getName());
				}
				if(user.getAddress() !=null) {
					userDb.get().setAddress(user.getAddress());
				}
				if(user.getCellPhone() !=null) {
					userDb.get().setCellPhone(user.getCellPhone());
				}
				if(user.getEmail() !=null) {
					userDb.get().setEmail(user.getEmail());
				}
				if(user.getPassword() !=null) {
					userDb.get().setPassword(user.getPassword());
				}
				if(user.getZone() !=null) {
					userDb.get().setZone(user.getZone());
				}
				userRepository.update(userDb.get());
				return userDb.get();
			}else {
				return user;
			}
		}else {
			return user;
		}
	}
	
	public boolean delete(int userId) {
		Boolean aBolean = getUser(userId).map(user->{
			userRepository.delete(user);
			return true;
		}).orElse(false);
		return aBolean;
	}
	
	public User authenticateUser(String email, String password) {
		Optional<User> usuario = userRepository.autenticarUsuario(email, password);
		if(usuario.isEmpty()) {
			return new User();
		}else{
			return usuario.get();
		}
	}
	
	/*public List<User> birthDayList(String monthBirthDay){
		return userRepository.birthDayList(monthBirthDay);
	}*/
}
