package com.hci.Pome.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hci.Pome.entities.Photo;
import com.hci.Pome.repositories.PhotoRepository;

import com.hci.Pome.exceptions.RecordNotFoundException;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository repository;

    public List<Photo> getAllPhotos()
    {
        List<Photo> photoList = repository.findAll();

        if(photoList.size() > 0)
        {
            return photoList;
        }

        else
        {
            return new ArrayList<Photo>();
        }
    }

    public Photo getPhotoById(Long id) throws RecordNotFoundException
    {
        Optional<Photo> photo = repository.findById(id);

        if(photo.isPresent())
        {
            return photo.get();
        }

        else
        {
            throw new RecordNotFoundException("No photo record exist for given id");
        }
    }

    public Photo createOrUpdatePhoto(Photo entity) throws RecordNotFoundException
    {
        Optional<Photo> photo = repository.findById(entity.getId());

        if(photo.isPresent())
        {
            Photo newEntity = photo.get();
            newEntity.setPhotoName(entity.getPhotoName());
            newEntity.setTags(entity.getTags());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        else
        {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deletePhotoById(Long id) throws RecordNotFoundException
    {
        Optional<Photo> photo = repository.findById(id);

        if(photo.isPresent())
        {
            repository.deleteById(id);
        }

        else
        {
            throw new RecordNotFoundException("No photo record exist for given id");
        }
    }
}