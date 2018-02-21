package feedback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FeedbackRepository {
	private List<Feedback> feedbackEntries = new CopyOnWriteArrayList<>();
	
	Collection<Feedback> getAllFeedback() {
		return new ArrayList<Feedback>(feedbackEntries);
	}
	
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

	public void save(Feedback feedback) {
		feedbackEntries.add(feedback);
	}
}
