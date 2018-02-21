package feedback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Feedback {
	private static final Logger LOGGER = LoggerFactory.getLogger(Feedback.class);
	
	@Id
	@GeneratedValue
	private long id;
	
	private long timestamp;
	private String name;
	private String feedback;
	
	public Feedback(long id, long timestamp, String name, String text) {
		this.id = id;
		this.timestamp = timestamp;
		this.name = name;
		this.feedback = text;
		LOGGER.info("Feedback created! id:{}, timestamp:{}, name:{}, text:{}", id, timestamp, name, text);
	}
	
	public long getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFeedback() {
		return feedback;
	}
}
