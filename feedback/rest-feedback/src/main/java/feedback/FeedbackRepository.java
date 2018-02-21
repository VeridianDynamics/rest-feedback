package feedback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A primitive, in-memory repository for {@link Feedback} data.
 * @author Jan Hron
 */
public class FeedbackRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackRepository.class);
	private List<Feedback> feedbackEntries = new CopyOnWriteArrayList<>();
	
	/**
	 * List all feedback data.
	 * @return All instances of {@link Feedback}.
	 */
	Collection<Feedback> getAllFeedback() {
		return new ArrayList<Feedback>(feedbackEntries);
	}
	
	/**
	 * List all feedback data entered with a specific name.
	 * @param name Name with which the feedback was entered.
	 * @return All instances of {@link Feedback} with a given name.
	 */
	Collection<Feedback> getFeedbackByName(String name) {
		Collection<Feedback> entriesByName = new ArrayList<>();
		for (Feedback f : feedbackEntries) {
			if (name == null) {
				if (f.getName() == null) {
					entriesByName.add(f);
				}
			} else {
				if (name.equals(f.getName())) {
					entriesByName.add(f);
				}
			}
		}
		return entriesByName;
	}

	/**
	 * Store the feedback instance.
	 * @param feedback The {@link Feedback} to be stored.
	 */
	void save(Feedback feedback) {
		feedbackEntries.add(feedback);
		LOGGER.info("Feedback aded to repository! id:{}, time:{}, name:{}, feedback:{}",
				feedback.getId(), feedback.getTime(), feedback.getName(), feedback.getFeedback());
	}
}
