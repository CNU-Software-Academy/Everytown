package marker.repository;

import marker.entity.TalkMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkMarkerRepository extends JpaRepository<TalkMarker, Integer> {
}