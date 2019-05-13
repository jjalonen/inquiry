package fi.haagahelia.MoodelInquiry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.MoodelInquiry.domain.QuestionType;
import fi.haagahelia.MoodelInquiry.domain.QuestionTypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class QuestionRepositoryTypeTEST {
	
	@Autowired
	private QuestionTypeRepository QTRepo;
	
	@Test
	public void findByTypeNameShouldReturnType() {
		List<QuestionType> QTypes = QTRepo.findByType("Radio");
		
		assertThat(QTypes).hasSize(1);
		assertThat(QTypes.get(0).getType()).isEqualTo("Radio");
		
	}
	
	@Test
	public void addNewType() {
		
		QuestionType Qtype = new QuestionType("SelectTEST");
		QTRepo.save(Qtype);
		
		assertThat(Qtype.getType()).isNotNull();
	}
	
	@Test
	public void deleteType() {
		QuestionType Qtype = new QuestionType("SelectTEST");
		QTRepo.save(Qtype);
		
		List<QuestionType> QTypes = QTRepo.findByType("SelectTEST");
		QTRepo.delete(QTypes.get(0));
		
		List<QuestionType> editedQT = QTRepo.findByType("SelectTEST");
		assertThat(editedQT).isEmpty();
	}
	
}
