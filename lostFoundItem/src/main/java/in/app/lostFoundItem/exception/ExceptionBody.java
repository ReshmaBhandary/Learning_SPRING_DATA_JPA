package in.app.lostFoundItem.exception;
import java.util.Date;

public class ExceptionBody {
	private Date timestamp;
	private String messag;
	private String details;
	
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessag() {
		return messag;
	}
	public void setMessag(String messag) {
		this.messag = messag;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ExceptionBody(Date timestamp, String messag, String details) {
		super();
		this.timestamp = timestamp;
		this.messag = messag;
		this.details = details;
	}
	
}
