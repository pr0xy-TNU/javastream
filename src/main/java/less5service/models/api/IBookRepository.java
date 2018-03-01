package less5service.models.api;

import java.util.Collection;
import less5service.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Bookmark, Long> {

    Collection<Bookmark> findByAccountUserName(String accountUserName);

}
