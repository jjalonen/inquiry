package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class QuestionType {
	private String openAnswer;
	private List<String> multipleAnswer;
	private int selectAnswer;

	public QuestionType() {
	}

	public String getOpenAnswer() {
		return openAnswer;
	}

	public void setOpenAnswer(String openAnswer) {
		this.openAnswer = openAnswer;
	}

	public List<String> getMultipleAnswer() {
		return multipleAnswer;
	}

	public void setMultipleAnswer(List<String> multipleAnswer) {
		this.multipleAnswer = multipleAnswer;
	}

	public int getSelectAnswer() {
		return selectAnswer;
	}

	public void setSelectAnswer(int selectAnswer) {
		this.selectAnswer = selectAnswer;
	}
}
