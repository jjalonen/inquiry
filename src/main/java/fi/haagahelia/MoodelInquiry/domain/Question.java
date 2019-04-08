package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Question {
	@Id
	@JsonView
	@Column(name = "questionId")
	private Long id;
	private String question, type;
	
	public Question() {}
	
	public Question(Long id, String question, String type) {
		super();
		this.id = id;
		this.question = question;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
