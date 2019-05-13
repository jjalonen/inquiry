package fi.haagahelia.MoodelInquiry.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompilationData {

	private List<String> answerPercentsByYear;

	public CompilationData() {
	}

	public CompilationData(List<AnswerForm> answers) {
		this.answerPercentsByYear = setAnswerPercentsByYear(answers);
	}

	public List<String> getAnswerPercentsByYear() {
		return answerPercentsByYear;
	}

	public List<String> setAnswerPercentsByYear(List<AnswerForm> answers) {
		List<String> answerPercentsByYear = new ArrayList<String>();
		List<String> answersByYear = new ArrayList<String>();
		String[] years = {"1", "2", "3", "4", "5"};
		int year = 1;

		System.out.println(answers.size());

		//go through all answerForms
		for (int i = 0; i < answers.size(); i++) {

			List<Answer> subAnswers = answers.get(i).getAnswers();
			
				if(subAnswers.get(i).getQuestionId() == 1 || subAnswers.get(i).getAnswer().equals(years[year])) {
					
					for(int j = 0; j < subAnswers.size(); j++) {
						
						if(subAnswers.get(j).getQuestionId() == 5) {

							System.out.println(subAnswers.get(j).getAnswer());
							answersByYear.add(subAnswers.get(j).getAnswer());
						}
						
					}
					int percent = answersByYear.size() / answers.size() * 100;
					answerPercentsByYear.add(Integer.toString(percent) + "%");
					year++;
					System.out.println(year);
				}
				
			}

		return answerPercentsByYear;
	}

}
