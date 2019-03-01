package io.marvi.oinos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(
            mappedBy = "country"
    )
    private List<Region> regions = new ArrayList<>();

    protected Country() {}

    public Country(String country) {
        this.name = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country that = (Country) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    public void addRegion(Region r) {
        this.regions.add(r);
        r.setCountry(this);
    }

    public void deleteRegion(Region r) {
        r.setCountry(null);
        this.regions.remove(r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
