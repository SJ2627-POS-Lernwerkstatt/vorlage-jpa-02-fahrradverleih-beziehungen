package ormapping.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import ormapping.model.Station;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class StationRepositoryTest {

    @Autowired
    private StationRepository repository;

    @Test
    void verify_station_is_saved_and_read() {
        // arrange
        Station station = new Station("Westbahnhof", "Europaplatz 2, 1150 Wien", 24);

        // act
        Station saved = repository.saveAndFlush(station);

        // assert
        assertThat(saved.getId()).isNotNull();
        assertThat(repository.findById(saved.getId())).hasValueSatisfying(found -> {
            assertThat(found.getName()).isEqualTo("Westbahnhof");
            assertThat(found.getAddress()).isEqualTo("Europaplatz 2, 1150 Wien");
            assertThat(found.getCapacity()).isEqualTo(24);
        });
    }

    @Test
    void verify_station_name_is_unique() {
        repository.saveAndFlush(new Station("Westbahnhof", "Europaplatz 2", 24));

        assertThatThrownBy(() -> repository.saveAndFlush(new Station("Westbahnhof", "Mariahilfer Gürtel", 10)))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
