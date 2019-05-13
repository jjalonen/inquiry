package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long questionId;
	private String answer;
	
	public Answer() {}
	
	public Answer(Long questionId, String answer) {
		this.questionId = questionId;
		this.answer = answer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswerString() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionId=" + questionId + ", answer=" + answer + "]";
	}	
	
	
}
