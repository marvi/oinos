package io.marvi.oinos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wine")
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @Basic
    @Column(name = "classification", nullable = true)
    private String classification;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Basic
    @Column(name = "alcohol_percent", nullable = true, precision = 0)
    private Integer alcoholPercent;

    @Basic
    @Column(name = "grapes", nullable = true)
    private String grapes;

    @Basic
    @Column(name = "color", nullable = true)
    private String color;

    @Basic
    @Column(name = "pairings", nullable = true)
    private String pairings;

    @Basic
    @Column(name = "aroma", nullable = true)
    private String aroma;

    @Basic
    @Column(name = "taste", nullable = true)
    private String taste;

    @Basic
    @Column(name = "added", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date added;

    @Basic
    @Column(name = "picture_url", nullable = true)
    private String pictureUrl;

    @OneToMany(
            mappedBy = "wine",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bottle> bottles = new ArrayList<>();

    @OneToMany(
            mappedBy = "wine",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WineComment> wineComments = new ArrayList<>();


    protected Wine() {
    }

    public Wine(String name) {
        this.name = name;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(Integer alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    public String getGrapes() {
        return grapes;
    }

    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPairings() {
        return pairings;
    }

    public void setPairings(String pairings) {
        this.pairings = pairings;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }


    public List<Bottle> getBottles() {
        return bottles;
    }

    public void setBottles(List<Bottle> bottles) {
        this.bottles = bottles;
    }

    public List<WineComment> getWineComments() {
        return wineComments;
    }

    public void setWineComments(List<WineComment> wineComments) {
        this.wineComments = wineComments;
    }

    public void addBottle(Bottle bottle) {
        this.bottles.add(bottle);
        bottle.setWine(this);
    }

    public void removeBottle(Bottle bottle) {
        this.bottles.remove(bottle);
        bottle.setWine(null);
    }

    public void addWineComment(WineComment wineComment) {
        this.wineComments.add(wineComment);
        wineComment.setWine(this);
    }

    public void removeWineComment(WineComment wineComment) {
        this.wineComments.remove(wineComment);
        wineComment.setWine(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine that = (Wine) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(alcoholPercent, that.alcoholPercent) &&
                Objects.equals(grapes, that.grapes) &&
                Objects.equals(color, that.color) &&
                Objects.equals(pairings, that.pairings) &&
                Objects.equals(aroma, that.aroma) &&
                Objects.equals(taste, that.taste) &&
                Objects.equals(added, that.added) &&
                Objects.equals(pictureUrl, that.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, alcoholPercent, grapes, color, pairings, aroma, taste, added, pictureUrl);
    }
}
