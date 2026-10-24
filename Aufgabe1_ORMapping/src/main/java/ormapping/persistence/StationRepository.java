package ormapping.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ormapping.model.Station;

public interface StationRepository extends JpaRepository<Station, Long> {
}
