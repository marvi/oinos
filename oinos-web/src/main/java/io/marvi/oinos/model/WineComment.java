package io.marvi.oinos.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "wine_comment")
public class WineComment {
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
    @JoinColumn(name="wine_id")
    private Wine wine;

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

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WineComment that = (WineComment) o;
        return id.equals(that.id) &&
                Objects.equals(content, that.content) &&
                Objects.equals(added, that.added);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, added);
    }
}
