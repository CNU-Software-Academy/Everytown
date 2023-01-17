package marker.repository;

import marker.entity.PhotoMarker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoMarkerRepository extends JpaRepository<PhotoMarker, Integer> {
}