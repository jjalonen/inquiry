package fi.haagahelia.MoodelInquiry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.MoodelInquiry.web.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {

	@Autowired
	private adminController adminController;
	
	@Autowired
	private inquiryController inquiryController;
	
	@Test
	public void controllerIsPresent() throws Exception {
		assertThat(adminController).isNotNull();
		assertThat(inquiryController).isNotNull();
	}	
}
