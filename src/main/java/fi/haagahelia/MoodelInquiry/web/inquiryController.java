package fi.haagahelia.MoodelInquiry.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fi.haagahelia.MoodelInquiry.domain.*;

@Controller
public class inquiryController {
	
	@Autowired
	private QuestionRepository QRepo;
	
	@Autowired
	private AnswerFormRepository Arepo;
	
	@RequestMapping(value="/open/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> GetQuestionsREST() {
		return (List<Question>) QRepo.findAll();
	}
	
	@RequestMapping(value="/open/question/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Question> GetQuestionByIdREST(@PathVariable("id") Long questionId) {
		return  QRepo.findById(questionId);
	}
	
	@RequestMapping(value="/open/answers", method = RequestMethod.GET)
	public @ResponseBody List<AnswerForm> GetAnswersREST() {
		return (List<AnswerForm>) Arepo.findAll();
	}
	
//	@RequestMapping(value="/open/answer/{id}", method = RequestMethod.GET)
//	public @ResponseBody List<AnswerForm> GetAnswersByQuestionIdREST(@PathVariable("id") Long id) {
//		return (List<AnswerForm>) Arepo.findById(id);
//	}
	
	@RequestMapping(value="/add/question", method = RequestMethod.POST)
	public void addQuestion(@RequestBody Question question) {
		QRepo.save(question);
	}
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/open/add/answer", method = RequestMethod.POST)
	public void addAnswer(@RequestBody AnswerForm answer) {
		Arepo.save(answer);
	}
}
