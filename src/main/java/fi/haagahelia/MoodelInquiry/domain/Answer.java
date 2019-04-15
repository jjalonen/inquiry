package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	
	@JoinColumn(name = "questionId", nullable = false)
	private Long questionId;
	
	public Answer() {}
	
	public Answer(String answer, Long questionId) {
		super();
		this.answer = answer;
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
