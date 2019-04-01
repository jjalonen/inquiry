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

			QuestionType type = new QuestionType();
			type.setOpenAnswer("Open");
			
			QuestionType type2 = new QuestionType();
			List<String> multiple = new ArrayList<>();
			multiple.add("yksi");
			multiple.add("kaksi");
			
			type2.setMultipleAnswer(multiple);
			
			QRepo.save(new Question("1insert question here", type));		
			QRepo.save(new Question("2insert question here", type2));	
		};
	}

}
