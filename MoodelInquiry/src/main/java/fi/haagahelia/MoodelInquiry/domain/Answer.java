package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	

	//TODO
	private Long questionId;
	
	public Answer() {}
	
	public Answer(String answer) {
		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
