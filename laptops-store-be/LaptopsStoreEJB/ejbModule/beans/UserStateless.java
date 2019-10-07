package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import dto.LoginDTO;
import dto.RegisterDTO;
import dto.UserFirstNameDTO;
import model.Role;
import model.User;

/**
 * Session Bean implementation class UserStateless
 */
@Stateless
@LocalBean
public class UserStateless implements UserStatelessRemote {

	@PersistenceContext
	EntityManager em;

	public UserStateless() {
	}

	@Override
	public LoginDTO logIn(LoginDTO userRequest) {
		String password = new String(Base64.encode(userRequest.getPassword().getBytes()));
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :pass");
		q.setParameter("email", userRequest.getEmail());
		q.setParameter("pass", password);
		if (q.getResultList().get(0) == null) {
			return null;
		}
		User user = (User) q.getResultList().get(0);

		LoginDTO loginResponse = new LoginDTO(user.getEmail(), user.getPassword(), user.getRole().getName());
		return loginResponse;
	}

	@Override
	public boolean register(RegisterDTO userRequest) {
		User user = new User();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		String passwordHash = new String(Base64.encode(userRequest.getPassword().getBytes()));
		user.setPassword(passwordHash);
		user.setDeliveryAddress(userRequest.getDeliveryAddress());
		Role role = new Role();
		role.setIdRole(2);
		user.setRole(role);

		em.persist(user);

		return true;
	}

	@Override
	public String isUserOk(String email, String password) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.password LIKE :pass");
		q.setParameter("email", email);
		q.setParameter("pass", password);
		if (q.getResultList().isEmpty()) {
			return "User doesn't exist!";
		}
		User user = (User) q.getResultList().get(0);
		return user.getRole().getName();
	}

	@Override
	public UserFirstNameDTO getUserFirstName(String email) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email");
		q.setParameter("email", email);
		if (q.getResultList().isEmpty()) {
			return null;
		}
		User user = (User) q.getResultList().get(0);
		return new UserFirstNameDTO(user.getFirstName());
	}

	@Override
	public int getIdUser(String email) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email");
		q.setParameter("email", email);
		User user = (User) q.getResultList().get(0);
		return user.getIdUser();
	}

}
