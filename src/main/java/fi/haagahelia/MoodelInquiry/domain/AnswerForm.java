package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class AnswerForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany  (cascade=CascadeType.ALL)
	private List<Answer> answers;
	
	public AnswerForm() {}
	
	public AnswerForm(List<Answer> answers) {
		super();
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}



	
	
}

