package dto;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadDTO {
	private byte[] image;

	public FileUploadDTO() {
	}

	public byte[] getImage() {
		return image;
	}

	@FormParam("image")
	@PartType("application/octet-stream")
	public void setImage(byte[] image) {
		this.image = image;
	}
}