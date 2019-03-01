package io.marvi.oinos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bottle")
public class Bottle {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "price", nullable = true)
    private Integer price;

    @Basic
    @Column(name = "vintage", nullable = true)
    private Integer vintage;

    @Column(name = "bought", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date bought;

    @Column(name = "consumed_at", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date consumedAt;

    @Column(name = "isConsumed", nullable = false)
    private Boolean isConsumed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="wine_id")
    private Wine wine;

    @OneToMany(
            mappedBy = "bottle"
    )
    private List<BottleComment> bottleComments= new ArrayList<>();

    public Bottle(Wine wine, Integer vintage) {
        this.setWine(wine);
        this.setVintage(vintage);
        this.isConsumed = false;
    }

    public Bottle(Wine wine, Integer vintage, Integer price, Date bought) {
        this.setWine(wine);
        this.setVintage(vintage);
        this.setPrice(price);
        this.setBought(bought);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVintage() {
        return vintage;
    }

    public void setVintage(Integer vintage) {
        this.vintage = vintage;
    }

    public Date getBought() {
        return bought;
    }

    public void setBought(Date bought) {
        this.bought = bought;
    }

    public Boolean getIsConsumed() {
        return isConsumed;
    }

    public void setIsConsumed(Boolean isConsumed) {
        this.isConsumed = isConsumed;
    }

    public List<BottleComment> getBottleComments() {
        return bottleComments;
    }

    public Date getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(Date consumedAt) {
        this.consumedAt = consumedAt;
    }

    public Boolean getConsumed() {
        return isConsumed;
    }

    public void setConsumed(Boolean consumed) {
        isConsumed = consumed;
    }

    public void setBottleComments(List<BottleComment> bottleComments) {
        this.bottleComments = bottleComments;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public void addBottleComment(BottleComment bottleComment) {
        this.bottleComments.add(bottleComment);
        bottleComment.setBottle(this);
    }

    public void removeBottleComment(BottleComment bottleComment) {
        this.bottleComments.remove(bottleComment);
        bottleComment.setBottle(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottle that = (Bottle) o;
        return id.equals(that.id) &&
                Objects.equals(price, that.price) &&
                Objects.equals(vintage, that.vintage) &&
                Objects.equals(bought, that.bought);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vintage, bought);
    }
}
