package feedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Feedback {
	private static final Logger LOGGER = LoggerFactory.getLogger(Feedback.class);
	
	private long id;
	private long timestamp;
	private String name;
	private String feedback;
	
	public Feedback(long id, long timestamp, String name, String feedback) {
		this.id = id;
		this.timestamp = timestamp;
		this.name = name;
		this.feedback = feedback;
		LOGGER.info("Feedback created! id:{}, timestamp:{}, name:{}, feedback:{}", id, timestamp, name, feedback);
	}
	
	public Feedback() {}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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
