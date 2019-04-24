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
	private String questionText;
	
	@ManyToOne
	@JoinColumn(name = "typeId")
	private QuestionType questionType;
	@ElementCollection
	@JsonView
	private List<String> responseOptions;
	
	public Question() {}
	
	public Question(Long id, String questionText, QuestionType questionType,  List<String> responseOptions) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.questionType = questionType;
		this.responseOptions = responseOptions;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getResponseOptions() {
		return responseOptions;
	}

	public void setResponseOptions(List<String> responseOptions) {
		this.responseOptions = responseOptions;
	}
}
