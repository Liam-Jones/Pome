package com.hci.Pome.repositories;

import com.hci.Pome.entities.Photo;
import com.hci.Pome.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Allows usage of auto-generated functions for interacting with Tags from database. Used in TagService
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByTagName(String tagName);
}