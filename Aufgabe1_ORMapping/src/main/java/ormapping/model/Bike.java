package ormapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Bike extends AbstractPersistable<Long> {

    @NotNull
    @Size(min = 8, max = 8)
    @Column(length = 8, nullable = false, unique = true)
    private String inventoryNumber;

    @NotNull
    @Size(max = 64)
    @Column(length = 64, nullable = false)
    private String model;

    // "year" is a reserved word in H2.
    @NotNull
    @Column(name = "build_year", nullable = false)
    private Integer year;

    @NotNull
    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal purchasePrice;

    private LocalDate purchasedAt;

    private boolean electric;

    protected Bike() {
    }

    public Bike(String inventoryNumber, String model, Integer year, BigDecimal purchasePrice,
                LocalDate purchasedAt, boolean electric) {
        this.inventoryNumber = inventoryNumber;
        this.model = model;
        this.year = year;
        this.purchasePrice = purchasePrice;
        this.purchasedAt = purchasedAt;
        this.electric = electric;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public LocalDate getPurchasedAt() {
        return purchasedAt;
    }

    public boolean isElectric() {
        return electric;
    }
}
