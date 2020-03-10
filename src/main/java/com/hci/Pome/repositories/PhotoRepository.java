package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Optional<Photo> findByPhotoName(String photoName);
}