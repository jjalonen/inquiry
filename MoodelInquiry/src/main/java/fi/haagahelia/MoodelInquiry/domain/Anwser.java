package fi.haagahelia.MoodelInquiry.domain;

import javax.persistence.*;

@Entity
public class Anwser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	
	@JoinColumn(name = "id")
	private Long questionId;
	
	public Anwser() {}
	
	public Anwser(String anwser) {
		super();
		this.answer = anwser;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
