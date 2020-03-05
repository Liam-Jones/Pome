package com.hci.Pome.entities;

import javax.persistence.*;
import java.util.List;

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

    public String tagsToClasses()
    {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < tags.toArray().length; i++) {
            sb.append(tags.toArray()[i].toString() + " ");
        }

        return sb.toString();
    }
}