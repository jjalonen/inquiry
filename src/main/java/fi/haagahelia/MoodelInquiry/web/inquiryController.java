package fi.haagahelia.MoodelInquiry.web;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
		List<Question> questions = (List<Question>) QRepo.findAll();
		Iterator<Question> it = questions.iterator();
		while(it.hasNext()) {
			Question question  = it.next();
			if(question.getResponseOptions().get(0).equals("")) {
				question.setResponseOptions(null);
			}
		}
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
	
	@RequestMapping(value="/add/question", method = RequestMethod.POST)
	public void addQuestion(@RequestBody Question question) {
		QRepo.save(question);
	}
//	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value="/open/add/answer", method = RequestMethod.POST)
	public void addAnswer(@RequestBody AnswerForm answerForm) {
		Arepo.save(answerForm);
	}
	
	@RequestMapping(value="/open/data", method = RequestMethod.GET)
	public @ResponseBody CompilationData getCompilationData() {
		List<AnswerForm> answers = (List<AnswerForm>) Arepo.findAll();
		
		CompilationData data = new CompilationData(answers);
		
		return data;
		
	}
}
