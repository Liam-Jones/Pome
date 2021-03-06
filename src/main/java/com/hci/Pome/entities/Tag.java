package com.hci.Pome.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Creates the tag table and allows for creation of Tag objects which can be stored and and extracted from this
 * table
 */

@Entity
@Table(name = "Tag", schema = "testdb", uniqueConstraints = {
        @UniqueConstraint(columnNames = "TagName", name = "uniqueNameConstraint")})
public class Tag {
    @Id
    @Column(name = "TagID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tagId;

    @Column(name = "TagName", unique = true)
    private String tagName;

    //Describes the Tag side of the many-to-many relationship, the tags will be mapped by the "tags" attribute of each
    //Photo
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private List<Photo> photos;

    protected Tag() {}

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag(String tagName, List<Photo> photos) {
        this.tagName = tagName;
        this.photos = photos;
    }

    @Override
    public String toString() {
        return tagName;
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

    public List<Photo> getPhotos()
    {
        return photos;
    }

    public void setPhotos(List<Photo> photos)
    {
        this.photos = photos;
    }
}
