package feedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Feedback {
	private static final Logger LOGGER = LoggerFactory.getLogger(Feedback.class);
	private long id;
	private long timestamp;
	private String name;
	private String text;
	
	public Feedback(long id, long timestamp, String name, String text) {
		this.id = id;
		this.timestamp = timestamp;
		this.name = name;
		this.text = text;
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
	
	public String getText() {
		return text;
	}
}
