package com.hci.Pome.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Creates the photo table and allows for creation of Photo objects which can be stored and and extracted from this
 * table
 */

@Entity
@Table(name = "Photo", schema = "testdb", uniqueConstraints = {
        @UniqueConstraint(columnNames = "PhotoName", name = "uniqueNameConstraint")})
public class Photo {
    @Id
    @Column(name = "PhotoID")
    @GeneratedValue
    private Long photoId;

    @Column(name = "PhotoName")
    private String photoName;

    // Creates the junction table between Photos and Tags.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "PhotoTag", schema = "testdb",
      joinColumns = @JoinColumn(name = "PhotoID"), inverseJoinColumns = @JoinColumn(name = "TagID")
    )
    private List<Tag> tags;

    protected Photo() {}

    public Photo(String photoName) {
        this.photoName = photoName;
    }

    public Photo(String photoName, List<Tag> tags) {
        this.photoName = photoName;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format(
                "Photo[id=%d, photoName='%s']", photoId, photoName);
    }

    public Long getId() {
        return photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getTags() {
        return tags;
    }

    /**
     * A method which allows Thymeleaf to more easily convert the tags of a photo to classes within the view.
     *
     * @return A string of space separated classes to be used in the view.
     */
    public String tagsToClasses()
    {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < tags.toArray().length; i++) {
            sb.append(tags.toArray()[i].toString() + " ");
        }

        return sb.toString();
    }
}