package fi.haagahelia.MoodelInquiry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.MoodelInquiry.domain.Kayttaja;
import fi.haagahelia.MoodelInquiry.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTEST {
	
	@Autowired
	private UserRepository URepo;
	
	@Test
	public void createNewUser() {
		Kayttaja kayttaja = new Kayttaja("Tester", "$2a$10$mxNSGDPJieMK3c4bCezsEOzxjrpRDvBZR1eQaQPVcceAEdvGO0iVS", "user");
		URepo.save(kayttaja);
		
		assertThat(kayttaja.getId()).isNotNull();
		
	}
	
	@Test
	public void findByUsername() {
		Kayttaja kayttajat = URepo.findByUsername("admin");
		
		kayttajat.getRole().equals("admin");
	}
}
