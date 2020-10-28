package mx.com.rappi.movie.rest.pojo;

import java.io.Serializable;

public class GeneralResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private String status;
	
	private String content;

	public GeneralResponse(String status, String content) {
		super();
		this.status = status;
		this.content = content;
	}

	public GeneralResponse() {
		// For JSON
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
