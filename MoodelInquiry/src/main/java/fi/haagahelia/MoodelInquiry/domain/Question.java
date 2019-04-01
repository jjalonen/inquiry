package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String questionText;
	private String questionAnswer;
	
	public Question() {}
	
	public Question(String questionText, String questionAnswer) {
		super();
		this.questionText = questionText;
		this.questionAnswer = questionAnswer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", questionAnswer=" + questionAnswer + "]";
	}
}
