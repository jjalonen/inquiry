package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String question;
	private QuestionType questiontype;
	
	public Question() {}
	
	public Question(String question, String type) {
		super();
		this.question = question;
	}

	public QuestionType getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(QuestionType questiontype) {
		this.questiontype = questiontype;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + "]";
	}
}
