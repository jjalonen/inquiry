package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

public class QuestionType {
	private String openAnwser;
	private List<String> multipleAnwser;
	private int selectAnwser;

	public QuestionType() {
	}

	public QuestionType(String openAnwser, List<String> multipleAnwser, int selectAnwser) {
		super();
		this.openAnwser = openAnwser;
		this.multipleAnwser = multipleAnwser;
		this.selectAnwser = selectAnwser;
	}

	public String getOpenAnwser() {
		return openAnwser;
	}

	public void setOpenAnwser(String openAnwser) {
		this.openAnwser = openAnwser;
	}

	public List<String> getMultipleAnwser() {
		return multipleAnwser;
	}

	public void setMultipleAnwser(List<String> multipleAnwser) {
		this.multipleAnwser = multipleAnwser;
	}

	public int getSelectAnwser() {
		return selectAnwser;
	}

	public void setSelectAnwser(int selectAnwser) {
		this.selectAnwser = selectAnwser;
	}

}
