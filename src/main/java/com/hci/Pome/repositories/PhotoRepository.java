package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PhotoRepository extends JpaRepository<Photo, Long>, PhotoRepositoryCustom {

}