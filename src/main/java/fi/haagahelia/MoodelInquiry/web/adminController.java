package fi.haagahelia.MoodelInquiry.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.MoodelInquiry.domain.AnswerRepository;
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
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
