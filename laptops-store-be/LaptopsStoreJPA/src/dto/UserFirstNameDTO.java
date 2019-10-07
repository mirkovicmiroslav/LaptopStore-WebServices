package dto;

import java.io.Serializable;

public class UserFirstNameDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9056174953089289697L;
	private String firstName;
	
	public UserFirstNameDTO() {
		
	}
	
	public UserFirstNameDTO(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
