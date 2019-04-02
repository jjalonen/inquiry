package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String question, type;
	
	public Question() {}
	
	public Question(String question, String type) {
		super();
		this.question = question;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
