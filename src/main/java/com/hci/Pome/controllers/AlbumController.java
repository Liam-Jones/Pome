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

@Controller
public class AlbumController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView initialPage()
    {
        ModelAndView modelAndView = new ModelAndView();

        List<Photo> photos = photoService.getAllPhotos();
        for(Photo photo : photos)
        {
            photo.setPhotoName("images/" + photo.getPhotoName());
        }
        modelAndView.addObject("photos", photos);
        modelAndView.setViewName("albumView");

        return modelAndView;
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<List<Photo>> refreshPhotos()
    {
        List<Photo> list = photoService.getAllPhotos();

        return new ResponseEntity<List<Photo>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "UploadPhoto", method = RequestMethod.POST)
    public void uploadPhoto(@RequestBody String photoDetails) {

    }
}
