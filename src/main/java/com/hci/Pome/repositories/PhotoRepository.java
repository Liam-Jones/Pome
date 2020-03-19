package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Allows usage of auto-generated functions for interacting with Photos from database. Used in PhotoService
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Optional<Photo> findByPhotoName(String photoName);
}