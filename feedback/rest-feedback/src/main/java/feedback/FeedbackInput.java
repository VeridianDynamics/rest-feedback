package feedback;

public class FeedbackInput {
	private String name;
	private String feedback;
	
	public FeedbackInput(String name, String feedback) {
		this.name = name;
		this.feedback = feedback;
	}
	
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
