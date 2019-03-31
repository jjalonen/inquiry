package fi.haagahelia.MoodelInquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MoodelInquiry.domain.QuestionRepository;
import fi.haagahelia.MoodelInquiry.domain.Question;

@SpringBootApplication
public class MoodelInquiryApplication {

	private static final Logger log = LoggerFactory.getLogger(MoodelInquiryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MoodelInquiryApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner questionData(QuestionRepository QRepo) {
		return (args)-> {
			
			log.info("save some questions");
			QRepo.save(new Question(0, "1insert question here", "1insert answer here"));
			QRepo.save(new Question(0, "2insert question here", "2insert answer here"));
			
			log.info("fetch questions");
			for(Question question : QRepo.findAll()) {
				log.info(question.toString());
			}
			
			
			
		};
	}

}
