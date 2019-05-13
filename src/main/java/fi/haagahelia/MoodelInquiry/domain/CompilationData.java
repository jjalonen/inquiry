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

				if (answer.getQuestionId() == 1 && answer.getAnswerString().equals(year)) {
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
					
					//there are some answers from the dev stage
					//this makes them not break the code
					if(answer.getAnswerString().length() > 1) {
						answer.setAnswer("3");
					}
					System.out.println("GET ANSWER() " + answer.getAnswerString());
					System.out.println(answer.toString());
					String str = answer.getAnswerString();
					switch (str) {
					case "1":
						answer1++;
						System.out.println("case 1 called");
						break;
					case "2":
						answer2++;
						System.out.println("case 2 called");
						break;
					case "3":
						answer3++;
						System.out.println("case 3 called");
						break;
					case "4":
						answer4++;
						System.out.println("case 4 called");
						break;
					case "5":
						answer5++;
						System.out.println("case 5 called");
						break;
					default:
						System.out.println("default");
						break;
					}
				}
			}
		}
		
		int one = answer1 / StudentAnswersByYear.size() * 100;
		int two = answer2 / StudentAnswersByYear.size() * 100;
		int three = answer3 / StudentAnswersByYear.size() * 100;
		int four = answer4 / StudentAnswersByYear.size() * 100;
		int five = answer5 / StudentAnswersByYear.size() * 100;
		
		System.out.println(one + " " + two + " " + three + " " + four + " " + five);
		//calculate percentages and parse to Strings
		String answer1Percentage = Integer.toString(one) + " %";
		String answer2Percentage = Integer.toString(two) + " %";
		String answer3Percentage = Integer.toString(three) + " %";
		String answer4Percentage = Integer.toString(four) + " %";
		String answer5Percentage = Integer.toString(five) + " %";
		
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
