package feedback;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class FeedbackRepositoryTests {

	private static final String NAME = "Name";
	private static final String FEEDBACK_TEXT = "Feedback text";
	private static final String TIME = "2018-02-21T10:55:21.875Z";

	@Test
	public void addElement_listElements_elementPresent() {
		AtomicLong idProvider = new AtomicLong();
		FeedbackRepository repository = setupRepository();
		Feedback feedback = createSampleFeedback(idProvider, NAME, FEEDBACK_TEXT);
		repository.save(feedback);
		
		Collection<Feedback> feedbacks = repository.getAllFeedback();
		
		assertEquals(feedbacks.size(), 1);
	}
	
	// TODO: Add more tests.

	/**
	 * Creates a sample Feedback instance.
	 * @param idProvider {@link AtomicLong} to provide an ID.
	 * @param name Name field.
	 * @param text Text field.
	 * @return The {@link Feedback} instance.
	 */
	private Feedback createSampleFeedback(AtomicLong idProvider, String name, String text) {
		return new Feedback(idProvider.incrementAndGet(), TIME, name, text);
	}

	/**
	 * Sets up a repository for testing.
	 * @return New repository.
	 */
	private FeedbackRepository setupRepository() {
		return new FeedbackRepository();
	}
}
