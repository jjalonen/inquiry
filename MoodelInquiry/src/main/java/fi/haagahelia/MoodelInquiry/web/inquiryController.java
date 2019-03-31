package fi.haagahelia.MoodelInquiry.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.MoodelInquiry.domain.Question;
import fi.haagahelia.MoodelInquiry.domain.QuestionRepository;

@Controller
public class inquiryController {
	
	@Autowired
	private QuestionRepository QRepo;
	
	
	//Show everything as JSON
	@RequestMapping(value="/", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionsREST() {
		return (List<Question>) QRepo.findAll();
	}

}
