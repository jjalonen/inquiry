package fi.haagahelia.MoodelInquiry;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.MoodelInquiry.domain.*;
import fi.haagahelia.MoodelInquiry.domain.User;
import fi.haagahelia.MoodelInquiry.domain.UserRepository;

@SpringBootApplication
public class MoodelInquiryApplication {

	private static final Logger log = LoggerFactory.getLogger(MoodelInquiryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MoodelInquiryApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner questionData(QuestionRepository QRepo, AnswerRepository ARepo, UserRepository urepository) {
		return (args)-> {		
			log.info("save some questions and answers");
			List<String> responseOptions = new ArrayList<>();
			responseOptions.add("Finanssi- ja talousasiantuntiakoulutus, tradenomi (AMK)");
			responseOptions.add("Hotelli- ja ravintola-alan liikkeenjohdon koulutus, restonomi (AMK)");
//			responseOptions.add("huono");
			
			List<String> question1ResponseOptions = new ArrayList<>();
			question1ResponseOptions.add("1.vuoden");
			question1ResponseOptions.add("2.vuoden");
			question1ResponseOptions.add("3.vuoden");
			question1ResponseOptions.add("4.vuoden");
			question1ResponseOptions.add("5.vuoden");
			

			QRepo.save(new Question(Long.valueOf(1) ,"Minkä vuoden opiskelija olet?", "Radio", question1ResponseOptions ));		
			QRepo.save(new Question(Long.valueOf(2) ,"Mikä on koulutusalasi?", "Select", responseOptions));	
			QRepo.save(new Question(Long.valueOf(3) ,"Miten moodle toimii mielestäsi?", "Open text", null ));	
			
			ARepo.save(new Answer("Pretty good", Long.valueOf(1)));		
			ARepo.save(new Answer("Terrible", Long.valueOf(1)));	
			ARepo.save(new Answer("Awesome", Long.valueOf(2)));	
			
			log.info("One user to rule them all");
			User userAdmin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(userAdmin);
		};
	}

}
