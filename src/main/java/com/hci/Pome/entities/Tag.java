package com.hci.Pome.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tag", schema = "testdb")
public class Tag {
    @Id
    @Column(name = "TagID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tagId;

    @Column(name = "TagName")
    private String tagName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private List<Photo> photos;

    protected Tag() {}

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return String.format(
                "Tag[id=%d, photoName='%s']", tagId, tagName);
    }

    public Long getId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
