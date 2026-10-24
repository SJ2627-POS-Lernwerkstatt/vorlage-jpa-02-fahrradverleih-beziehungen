package ormapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Station extends AbstractPersistable<Long> {

    @NotNull
    @Size(max = 40)
    @Column(length = 40, nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(max = 120)
    @Column(length = 120, nullable = false)
    private String address;

    @NotNull
    @Column(nullable = false)
    private Integer capacity;

    protected Station() {
    }

    public Station(String name, String address, Integer capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
