package feedback;

/**
 * Internal representation of the received feedback.
 * @author Jan Hron
 */
public class Feedback {
	private long id;
	private String time;
	private String name;
	private String feedback;
	
	/**
	 * Constructor of the instance.
	 * @param id The ID.
	 * @param time Time of entry in UTC.
	 * @param name The name field.
	 * @param feedback The feedback field.
	 */
	public Feedback(long id, String time, String name, String feedback) {
		this.id = id;
		this.time = time;
		this.name = name;
		this.feedback = feedback;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setTimestamp(String time) {
		this.time = time;
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

	public String getTime() {
		return time;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFeedback() {
		return feedback;
	}
}
