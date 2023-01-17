package marker.repository;

import marker.entity.TmpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmpUserRepository extends JpaRepository<TmpUser, String> {
}