package ormapping.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ormapping.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
