package fi.haagahelia.MoodelInquiry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String question;
	
	@ManyToOne
	@JsonIgnore
	private List<QuestionType> types;
	
	public Question() {}
	
	public Question(String question, QuestionType type) {
		super();
		this.question = question;
		types = new ArrayList<>();
		types.add(type);
	}
	
	public List<QuestionType> getTypes() {
		return types;
	}

	public void setTypes(List<QuestionType> types) {
		this.types = types;
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
