package starter.springweb.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import starter.springweb.domain.user.entity.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
