package beans;

import javax.ejb.Remote;

import dto.LoginDTO;
import dto.RegisterDTO;
import dto.UserFirstNameDTO;

@Remote
public interface UserStatelessRemote {

	public LoginDTO logIn(LoginDTO userRequest);

	public boolean register(RegisterDTO userRequest);

	public String isUserOk(String email, String password);

	public UserFirstNameDTO getUserFirstName(String email);

	public int getIdUser(String email);
}
