package com.hci.Pome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlbumController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialPage()
    {
        return "albumView";
    }
}
