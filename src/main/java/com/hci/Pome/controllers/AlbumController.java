package com.hci.Pome.controllers;

import com.hci.Pome.entities.Photo;
import com.hci.Pome.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

/**
 * Handles requests for various functionalities associated with the album view. Populates the album view with initial
 * data from the in memory database
 */
@Controller
public class AlbumController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView initialPage()
    {
        ModelAndView modelAndView = new ModelAndView();

        List<Photo> photos = photoService.getAllPhotos();

        //Alters the names of each photo before adding them to the model, allows for easier use in templating.
        for(Photo photo : photos)
        {
            photo.setPhotoName("images/" + photo.getPhotoName());
        }
        modelAndView.addObject("photos", photos);
        modelAndView.addObject("arrayLength", photos.toArray().length);
        modelAndView.setViewName("albumView");

        return modelAndView;
    }

    @RequestMapping(value = "UploadPhoto", method = RequestMethod.POST)
    public void uploadPhoto(@RequestBody String photoDetails) {

    }
}
