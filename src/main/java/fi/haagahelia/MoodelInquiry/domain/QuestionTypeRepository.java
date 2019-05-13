package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {
	
	List<QuestionType> findByType(String type);
	
}
