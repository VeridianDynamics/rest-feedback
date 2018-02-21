package feedback;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * Several tests to demonstrate testing of the application using {@link MockMvc}.
 * @author Jan Hron
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackControllerTests {

    private static final String EMPTY_FEEDBACK_RESPONSE = "Empty";
	private static final String ANONYMOUS_USER = "Anonymous";
	private static final String FEEDBACK_NONEPMTY_NAME_EMPTY = "{\"feedback\": \"string\", \"name\": \"\" }";
	private static final String FEEDBACK_EMPTY_NAME_RASHMIKA_ELS = "{\"feedback\": \"\", \"name\": \"Rashmika Els\" }";
	private static final String FEEDBACK_LOVING_IT_NAME_RASHMIKA_ELS = "{\"feedback\": \"Loving it!\", \"name\": \"Rashmika Els\" }";
	private static final String FEEDBACK_LIKE_NAME_BILL = "{\"feedback\": \"Like it.\", \"name\": \"Bill\" }";
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void postFeedback_nameIsEmpty_nameIsReplaced() throws Exception {
    	addFeedbackWithData(FEEDBACK_NONEPMTY_NAME_EMPTY)
    			.andDo(print()).andExpect(jsonPath("$.name").value(ANONYMOUS_USER));
    }
    
    @Test
    public void postFeedback_feedbackIsEmpty_feedbackIsReplaced() throws Exception {
    	addFeedbackWithData(FEEDBACK_EMPTY_NAME_RASHMIKA_ELS)
    			.andDo(print()).andExpect(jsonPath("$.feedback").value(EMPTY_FEEDBACK_RESPONSE));
    }
    
    @Test
    public void postFeedback_statusIsSuccessful() throws Exception {
    	addFeedbackWithData(FEEDBACK_LOVING_IT_NAME_RASHMIKA_ELS)
    			.andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void getFeedback_setFilter_correctFeedbackIsShown() throws Exception {
    	addFeedbackWithData(FEEDBACK_LOVING_IT_NAME_RASHMIKA_ELS);
    	addFeedbackWithData(FEEDBACK_LIKE_NAME_BILL);
    	addFeedbackWithData(FEEDBACK_LIKE_NAME_BILL);
    	
    	this.mockMvc.perform(get("/list").param("name", "Bill"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("Bill"))
        .andExpect(jsonPath("$[1].name").value("Bill"))
        .andExpect(jsonPath("$.size()").value("2"));
    }

	private ResultActions addFeedbackWithData(String data) throws Exception {
		return this.mockMvc.perform(post("/feedback")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(data));
	}
	
	// TODO: Add some more tests maybe?
}