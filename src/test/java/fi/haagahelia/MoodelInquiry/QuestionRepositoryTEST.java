package fi.haagahelia.MoodelInquiry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.MoodelInquiry.domain.Question;
import fi.haagahelia.MoodelInquiry.domain.QuestionRepository;
import fi.haagahelia.MoodelInquiry.domain.QuestionTypeRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTEST {

	@Autowired
	private QuestionRepository QRepo;
	
	@Autowired
	private QuestionTypeRepository QTRepo;
	
	
	
	@Test 
	public void addNewQuestion() {
		
		List<String> question1ResponseOptions = new ArrayList<>();
		question1ResponseOptions.add("lyllikki");
		question1ResponseOptions.add("make");
		
		Question question = new Question (Long.valueOf(1), "Mikä on nimesi?", QTRepo.findByType("Radio").get(0), question1ResponseOptions);
		QRepo.save(question);
		
		assertThat(question.getId()).isNotNull();
	}
}
