package fi.haagahelia.MoodelInquiry.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.MoodelInquiry.domain.AnswerRepository;
import fi.haagahelia.MoodelInquiry.domain.Question;
import fi.haagahelia.MoodelInquiry.domain.QuestionRepository;

@Controller
public class adminController {

	@Autowired
	private QuestionRepository qRepository;
	
	@Autowired
	private AnswerRepository aRepository;
	
	@RequestMapping(value="/questionList")
	public String questionList (Model model) {
		model.addAttribute("questions", qRepository.findAll());
		return "questionList";
	}
	
	@RequestMapping(value="/add")
	public String add (Model model) {
		model.addAttribute("question", new Question());
		return "/addQuestion";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Question question) {
		qRepository.save(question);
		return "redirect:questionList";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id")Long id, Model model) {
		qRepository.deleteById(id);
		return "redirect:../questionList";
	}
	
	@RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
	public String editQuestion(@PathVariable("id")Long id, Model model) {
	model.addAttribute("question", qRepository.findById(id));
	return "edit";
}

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
