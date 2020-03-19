package com.hci.Pome.services;

import com.hci.Pome.entities.Tag;
import com.hci.Pome.exceptions.RecordNotFoundException;
import com.hci.Pome.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A service which allows for retrieving, creating, and deleting Tag objects from the database.
 */
@Service
public class TagService {

    @Autowired
    TagRepository repository;

    public List<Tag> getAllTags()
    {
        List<Tag> tagList = repository.findAll();

        if(tagList.size() > 0)
        {
            return tagList;
        }

        else
        {
            return new ArrayList<Tag>();
        }
    }

    public Tag getTagById(Long id) throws RecordNotFoundException
    {
        Optional<Tag> tag = repository.findById(id);

        if(tag.isPresent())
        {
            return tag.get();
        }

        else
        {
            throw new RecordNotFoundException("No tag record exist for given id");
        }
    }

    public Tag createOrUpdateTag(Tag entity) throws RecordNotFoundException
    {
        Optional<Tag> tag = repository.findByTagName(entity.getTagName());

        if(tag.isPresent())
        {
            Tag newEntity = tag.get();
            newEntity.setTagName(entity.getTagName());
            newEntity.setPhotos(entity.getPhotos());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        else
        {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteTagById(Long id) throws RecordNotFoundException
    {
        Optional<Tag> tag = repository.findById(id);

        if(tag.isPresent())
        {
            repository.deleteById(id);
        }

        else
        {
            throw new RecordNotFoundException("No tag record exist for given id");
        }
    }

    public void deleteTagByTagName(String tagName) throws RecordNotFoundException
    {
        Optional<Tag> tag = repository.findByTagName(tagName);

        if(tag.isPresent())
        {
            repository.deleteById(tag.get().getId());
        }

        else
        {
            throw new RecordNotFoundException("No tag record exist for given tag name");
        }
    }
}