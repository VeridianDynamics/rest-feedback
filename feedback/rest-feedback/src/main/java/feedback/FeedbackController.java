package feedback;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
	private final FeedbackRepository feedbackRepository = new FeedbackRepository();
	
	private final AtomicLong feedbackId = new AtomicLong();
		
	@RequestMapping(value = "/feedback", method = POST)
	@ResponseStatus(CREATED)
	public FeedbackInput acceptFeedback(@RequestBody FeedbackInput receivedFeedback) {
		final String name = validateFeedbackName(receivedFeedback.getName());
		final String feedbackText = validateFeedbackText(receivedFeedback.getFeedback());
		Feedback feedback = new Feedback(feedbackId.incrementAndGet(),
				System.currentTimeMillis(), name, feedbackText);
		feedbackRepository.save(feedback);
		return receivedFeedback;
	}

	private String validateFeedbackName(String name) {
		if (StringUtils.isEmpty(name)) {
			return "Anonymous";
		} else return name;
	}
	
	private String validateFeedbackText(String feedback) {
		if (StringUtils.isEmpty(feedback)) {
			return "Empty";
		} else return feedback;
	}

	@RequestMapping(value = "/list", method = GET)
	public Collection<Feedback> listFeedback(@RequestParam(value="name", required=false) String name) {
		if (name == null) {
			return this.feedbackRepository.getAllFeedback();
		} else {
			return this.feedbackRepository.getFeedbackByName(name);
		}
	}
}
