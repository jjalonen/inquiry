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

@SpringBootApplication
public class MoodelInquiryApplication {

	private static final Logger log = LoggerFactory.getLogger(MoodelInquiryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoodelInquiryApplication.class, args);
	}

	@Bean
	 public CommandLineRunner questionData(QuestionRepository QRepo, AnswerFormRepository ARepo, UserRepository urepository,
			QuestionTypeRepository questionTypeRepository) {
		return (args) -> {
//			log.info("save some questions and answers and questionType");
//			List<String> responseOptions = new ArrayList<>();
//			responseOptions.add("Finanssi- ja talousasiantuntiakoulutus tradenomi (AMK)");
//			responseOptions.add("Hotelli- ja ravintola-alan liikkeenjohdon koulutus restonomi (AMK)");
//			responseOptions.add("Johdon assistenttityön ja kielten koulutus tradenomi(AMK)");
//			responseOptions.add("Journalismikoulutus, medianomi(AMK)");
//			responseOptions.add("Liiketalouden koulutus tradenomi(AMK)");
//			responseOptions.add("Liikunnan ja vapaa-ajan koulutus liikunnanohjaaja(AMK)");
//			responseOptions.add("Matkailun koulutus restonomi(AMK)");
//			responseOptions.add("Matkailun liikkeenjohdon koulutus(AMK)");
//			responseOptions.add("Myynnin ja visuaalisen markkinoinnin koulutus tradenomi(AMK)");
//			responseOptions.add("Myyntityön koulutus tradenomi(AMK)");
//			responseOptions.add("Ruokatuotannon johtamisen koulutus restonomi(AMK)");
//			responseOptions.add("Tietojenkäsittelyn koulutus tradenomi (AMK)");
//			responseOptions.add("Englanninkieliset amk-tutkinnot");
//
			questionTypeRepository.save(new QuestionType("Radio"));
			questionTypeRepository.save(new QuestionType("Open Text"));
			questionTypeRepository.save(new QuestionType("Select"));
//
//			List<String> question1ResponseOptions = new ArrayList<>();
//			question1ResponseOptions.add("1.vuoden");
//			question1ResponseOptions.add("2.vuoden");
//			question1ResponseOptions.add("3.vuoden");
//			question1ResponseOptions.add("4.vuoden");
//			question1ResponseOptions.add("5.vuoden");
//
//			QRepo.save(new Question(Long.valueOf(1), "Minkä vuoden opiskelija olet?",
//					questionTypeRepository.findByType("Radio").get(0), question1ResponseOptions));
//			QRepo.save(new Question(Long.valueOf(2), "Mikä on koulutusalasi?",
//					questionTypeRepository.findByType("Select").get(0), responseOptions));
//			QRepo.save(new Question(Long.valueOf(3), "Miten moodle toimii mielestäsi?",
//					questionTypeRepository.findByType("Open Text").get(0), null));
//
//			ARepo.save(new Answer("1. vuoden", Long.valueOf(1)));
//			ARepo.save(new Answer("2. vuoden", Long.valueOf(1)));
//			ARepo.save(new Answer("Tietojenkäsittelyn koulutus tradenomi (AMK)", Long.valueOf(2)));
//			
//			log.info("Saving some answers");
//			List<Answer> answers = new ArrayList<>();
//			answers.add(new Answer(Long.valueOf(1), "ihan ok"));
//			answers.add(new Answer(Long.valueOf(2), "hyvin huono"));
//
//			
//			
//			ARepo.save(new AnswerForm(answers));
//			ARepo.save(new AnswerForm(new Answer(Long.valueOf(1), "Aivan täydellinen"), new Answer(Long.valueOf(2), "Ihan okke")));
//
			log.info("One user to rule them all");
			Kayttaja userAdmin = new Kayttaja("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(userAdmin);
		};
	}

}
