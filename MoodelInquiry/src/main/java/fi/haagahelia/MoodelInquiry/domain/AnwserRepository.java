package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnwserRepository extends CrudRepository<Anwser, Long>{
	List<Anwser> findByQuestionId(Long questionId);
}
