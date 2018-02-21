package feedback;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for feedback-related endpoints.
 * @author Jan Hron
 */
@RestController
public class FeedbackController {
	private final FeedbackRepository feedbackRepository = new FeedbackRepository();
	
	private final AtomicLong feedbackId = new AtomicLong();
		
	/**
	 * Endpoint accepting the feedback form data. 
	 * Creates a {@link Feedback} instance and stores it.
	 * @param receivedFeedback The received feedback
	 * @return The newly created object.
	 */
	@RequestMapping(value = "/feedback", method = POST)
	@ResponseStatus(CREATED)
	public Feedback acceptFeedback(@RequestBody FeedbackInput receivedFeedback) {
		final String name = validateFeedbackName(receivedFeedback.getName());
		final String feedbackText = validateFeedbackText(receivedFeedback.getFeedback());
		final Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		final String time = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC).toString();
		final Feedback feedback = new Feedback(feedbackId.incrementAndGet(), time,
				name, feedbackText);
		feedbackRepository.save(feedback);
		return feedback;
	}

	/**
	 * Checks that the name is not empty.
	 * If it is, replace it with "Anonymous".
	 * @param name The name.
	 * @return The original name or "Anonymous" if it was not present.
	 */
	private String validateFeedbackName(String name) {
		if (StringUtils.isEmpty(name)) {
			return "Anonymous";
		} else return name;
	}
	
	/**
	 * Checks that the feedback is not empty.
	 * If it is, replace it with "Empty".
	 * @param feedback The feedback text.
	 * @return The original feedback text or "Empty".
	 */
	private String validateFeedbackText(String feedback) {
		if (StringUtils.isEmpty(feedback)) {
			return "Empty";
		} else return feedback;
	}

	/**
	 * Endpoint listing feedback with optional filtering by name.
	 * Returns either all of it or a subset entered with a provided name.
	 * @param name The name to check.
	 * @return A {@link Collection} of {@link Feedback} data.
	 */
	@RequestMapping(value = "/list", method = GET)
	public Collection<Feedback> listFeedback(@RequestParam(value="name", required=false) String name) {
		if (name == null) {
			return this.feedbackRepository.getAllFeedback();
		} else {
			return this.feedbackRepository.getFeedbackByName(name);
		}
	}
}
