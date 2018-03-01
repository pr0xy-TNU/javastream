package less5service.models.api;

import java.util.Optional;
import less5service.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserName(String userName);
}
