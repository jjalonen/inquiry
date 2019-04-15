package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Question {
	@Id
	@JsonView
	@Column(name = "questionId")
	private Long id;
	private String question;
	private String questionType;
	@ElementCollection
	@JsonView
	private List<String> responseOptions;
	
	
	public Question() {}
	
	public Question(Long id, String question, String questionType,  List<String> responseOptions) {
		super();
		this.id = id;
		this.question = question;
		this.questionType = questionType;
		this.responseOptions = responseOptions;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getResponseOptions() {
		return responseOptions;
	}

	public void setResponseOptions(List<String> responseOptions) {
		this.responseOptions = responseOptions;
	}
}
