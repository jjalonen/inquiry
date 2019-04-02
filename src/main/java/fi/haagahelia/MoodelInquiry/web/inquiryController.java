package fi.haagahelia.MoodelInquiry.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.MoodelInquiry.domain.*;

@Controller
public class inquiryController {
	
	@Autowired
	private QuestionRepository QRepo;
	
	@Autowired
	private AnswerRepository Arepo;
	
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionsREST() {
		return (List<Question>) QRepo.findAll();
	}
	
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> answersREST() {
		return (List<Answer>) Arepo.findAll();
	}
	
	@RequestMapping(value="/add/question", method = RequestMethod.POST)
	public void addQuestion(@RequestBody Question question) {
		QRepo.save(question);
	}

}
