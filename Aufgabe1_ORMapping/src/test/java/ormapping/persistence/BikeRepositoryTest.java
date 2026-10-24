package ormapping.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import ormapping.model.Bike;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class BikeRepositoryTest {

    @Autowired
    private BikeRepository repository;

    @Test
    void verify_bike_is_saved_and_read() {
        // arrange
        Bike bike = new Bike("CITY0001", "Citybike 3", 2024, new BigDecimal("649.90"), LocalDate.of(2024, 3, 1), false);

        // act
        Bike saved = repository.saveAndFlush(bike);

        // assert
        assertThat(saved.getId()).isNotNull();
        assertThat(repository.findById(saved.getId())).hasValueSatisfying(found -> {
            assertThat(found.getInventoryNumber()).isEqualTo("CITY0001");
            assertThat(found.getModel()).isEqualTo("Citybike 3");
            assertThat(found.getYear()).isEqualTo(2024);
            assertThat(found.getPurchasePrice()).isEqualByComparingTo("649.90");
            assertThat(found.getPurchasedAt()).isEqualTo(LocalDate.of(2024, 3, 1));
            assertThat(found.isElectric()).isFalse();
        });
    }

    @Test
    void verify_inventory_number_is_unique() {
        repository.saveAndFlush(new Bike("CITY0001", "Citybike 3", 2024, new BigDecimal("649.90"), null, false));

        assertThatThrownBy(() -> repository.saveAndFlush(
                new Bike("CITY0001", "E-Bike 7", 2025, new BigDecimal("2499.00"), null, true)))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
