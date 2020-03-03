package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long>, PhotoRepositoryCustom {
    Optional<Photo> findByPhotoName(String photoName);
}