package fi.haagahelia.MoodelInquiry.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<Kayttaja, Long> {
	Kayttaja findByUsername(String username);
}