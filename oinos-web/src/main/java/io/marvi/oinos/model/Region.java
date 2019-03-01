package io.marvi.oinos.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "region", uniqueConstraints={@UniqueConstraint(name = "uq_region", columnNames = {"name", "country_id"})})
public class Region {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @Basic
    @Column(name = "latlong", nullable = true)
    private String latlong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;

    protected Region() {}

    public Region(String name, Country country) {
        this.name = name;
        this.country = country;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region that = (Region) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(latlong, that.latlong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, latlong);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country.getName() +
                '}';
    }
}
