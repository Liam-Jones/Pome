package com.hci.Pome.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Photo", schema = "testdb")
public class Photo {
    @Id
    @Column(name = "PhotoID")
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @Override
    public String toString() {
        return String.format(
                "Photo[id=%d, photoName='%s']", photoId, photoName);
    }

    public Long getId() {
        return photoId;
    }

    public String getFirstName() {
        return photoName;
    }
}