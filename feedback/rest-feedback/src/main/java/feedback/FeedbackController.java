package feedback;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FeedbackController {
	private final FeedbackRepository feedbackRepository = new FeedbackRepository();
	
	private final AtomicLong feedbackId = new AtomicLong();
		
	@RequestMapping(value = "/feedback", method = POST)
	public Feedback acceptFeedback(@RequestParam(value="name", defaultValue="Anonymous") String name,
									@RequestParam(value="text", defaultValue="empty") String text) {
		Feedback feedback = new Feedback(feedbackId.incrementAndGet(), System.currentTimeMillis(), name, text);
		feedbackRepository.save(feedback);
		return feedback;
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
