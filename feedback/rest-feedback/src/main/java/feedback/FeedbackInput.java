package feedback;

/**
 * Class representing the incoming feedback.
 * @author Jan Hron
 */
public class FeedbackInput {
	private String name;
	private String feedback;
	
	/**
	 * Dummy constructor for the JSON parser.
	 */
	public FeedbackInput() {}

	public void setName(String name) {
		this.name = name;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFeedback() {
		return feedback;
	}
}
