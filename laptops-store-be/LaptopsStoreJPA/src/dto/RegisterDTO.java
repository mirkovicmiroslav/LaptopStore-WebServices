package dto;

import java.io.Serializable;

public class RegisterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6910569777809863342L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String deliveryAddress;

	public RegisterDTO() {

	}

	public RegisterDTO(String firstName, String lastName, String email, String password, String deliveryAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.deliveryAddress = deliveryAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
