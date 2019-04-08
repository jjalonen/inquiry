package fi.haagahelia.MoodelInquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MoodelInquiry.domain.*;

@SpringBootApplication
public class MoodelInquiryApplication {

	private static final Logger log = LoggerFactory.getLogger(MoodelInquiryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MoodelInquiryApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner questionData(QuestionRepository QRepo, AnswerRepository ARepo) {
		return (args)-> {		
			log.info("save some questions");

			QRepo.save(new Question(Long.valueOf(1) ,"QUESTION 1", "Select"));		
			QRepo.save(new Question(Long.valueOf(2) ,"QUESTION 2", "Open text"));	
			QRepo.save(new Question(Long.valueOf(3) ,"QUESTION 3", "Radio"));	
			
			ARepo.save(new Answer("Pretty good", Long.valueOf(1)));		
			ARepo.save(new Answer("Terrible", Long.valueOf(1)));	
			ARepo.save(new Answer("Awesome", Long.valueOf(2)));	
			
		};
	}

}
