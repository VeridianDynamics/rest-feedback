package feedback;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {
	private final AtomicLong feedbackId = new AtomicLong();
	
	@RequestMapping("/feedback")
	public Feedback acceptFeedback(@RequestParam(value="name", defaultValue="Anonymous") String name,
									@RequestParam(value="text", defaultValue="empty") String text) {
		return new Feedback(feedbackId.incrementAndGet(), System.currentTimeMillis(), name, text);
	}

}
