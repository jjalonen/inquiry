package fi.haagahelia.MoodelInquiry.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompilationData {
	private PercentagesByYear year1;
	private PercentagesByYear year2;
	private PercentagesByYear year3;
	private PercentagesByYear year4;
	private PercentagesByYear year5;

	public CompilationData() {
	}

	public CompilationData(List<AnswerForm> answers) {
		this.year1 = calculateYearAnswerPecentages(answers, "1");
		this.year2 = calculateYearAnswerPecentages(answers, "2");
		this.year3 = calculateYearAnswerPecentages(answers, "3");
		this.year4 = calculateYearAnswerPecentages(answers, "4");
		this.year5 = calculateYearAnswerPecentages(answers, "5");
	}

	private PercentagesByYear calculateYearAnswerPecentages(List<AnswerForm> answers, String year) {
		List<AnswerForm> StudentAnswersByYear = new ArrayList<>();
		int answer1 = 0;
		int answer2 = 0;
		int answer3 = 0;
		int answer4 = 0;
		int answer5 = 0;
		
		//find all answerForms with the given study year
		for (int i = 0; i < answers.size(); i++) {
			List<Answer> subAnswers = answers.get(i).getAnswers();
			Iterator<Answer> it = subAnswers.iterator();

			while (it.hasNext()) {
				Answer answer = it.next();

				if (answer.getQuestionId() == 1 && answer.getAnswer().equals(year)) {
					System.out.println("can find answers for given year");
					StudentAnswersByYear.add(answers.get(i));
				}
			}
		}	
		//go through all the answers for the given year
		for (int i = 0; i < StudentAnswersByYear.size(); i++) {	
			List<Answer> subAnswers = StudentAnswersByYear.get(i).getAnswers();
			Iterator<Answer> it = subAnswers.iterator();
			
			while (it.hasNext()) {
				Answer answer = it.next();
		
				if (answer.getQuestionId() == 5) {
					System.out.println("questionId is 5");
					switch (answer.getAnswer()) {
					case ("1"):
						answer1++;
						break;
					case ("2"):
						answer2++;
						break;
					case ("3"):
						answer3++;
						break;
					case ("4"):
						answer4++;
						break;
					case ("5"):
						answer5++;
						break;
					default:
						break;
					}
				}
			}
		}
		//calculate percentages and parse to Strings
		String answer1Percentage = Integer.toString(answer1 / StudentAnswersByYear.size() * 100) + "%";
		String answer2Percentage = Integer.toString(answer2 / StudentAnswersByYear.size() * 100) + "%";
		String answer3Percentage = Integer.toString(answer3 / StudentAnswersByYear.size() * 100) + "%";
		String answer4Percentage = Integer.toString(answer4 / StudentAnswersByYear.size() * 100) + "%";
		String answer5Percentage = Integer.toString(answer5 / StudentAnswersByYear.size() * 100) + "%";
		
		System.out.println(answer1Percentage);
		System.out.println(answer2Percentage);
		System.out.println(answer3Percentage);
		System.out.println(answer4Percentage);
		System.out.println(answer5Percentage);
		
		PercentagesByYear percentagesByYear = new PercentagesByYear(answer1Percentage, answer2Percentage, answer3Percentage, answer4Percentage, answer5Percentage);
		return percentagesByYear;
	}

	public PercentagesByYear getYear1() {
		return year1;
	}

	public void setYear1(PercentagesByYear year1) {
		this.year1 = year1;
	}

	public PercentagesByYear getYear2() {
		return year2;
	}

	public void setYear2(PercentagesByYear year2) {
		this.year2 = year2;
	}

	public PercentagesByYear getYear3() {
		return year3;
	}

	public void setYear3(PercentagesByYear year3) {
		this.year3 = year3;
	}

	public PercentagesByYear getYear4() {
		return year4;
	}

	public void setYear4(PercentagesByYear year4) {
		this.year4 = year4;
	}

	public PercentagesByYear getYear5() {
		return year5;
	}

	public void setYear5(PercentagesByYear year5) {
		this.year5 = year5;
	}

}
