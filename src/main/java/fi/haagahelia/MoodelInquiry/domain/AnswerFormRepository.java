package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerFormRepository extends CrudRepository<AnswerForm, Long>{
//	List<AnswerForm> findByQuestionId(Long questionId);
}
