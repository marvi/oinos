package io.marvi.oinos.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bottle_comment")
public class BottleComment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    @Column(name = "content", nullable = true)
    private String content;

    @Basic
    @Column(name = "source", nullable = true)
    private String source;

    @Basic
    @Column(name = "added", nullable = true)
    private Date added;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bottle_id")
    private Bottle bottle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Bottle getBottle() {
        return bottle;
    }

    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BottleComment that = (BottleComment) o;
        return id.equals(that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(added, that.added);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, added);
    }
}
