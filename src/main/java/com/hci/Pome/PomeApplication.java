package com.hci.Pome;

import com.hci.Pome.entities.Photo;
import com.hci.Pome.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PomeApplication implements CommandLineRunner{

	@Autowired
	PhotoService photoService;

	public static void main(String[] args) {
		SpringApplication.run(PomeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Photo dogePhoto = new Photo("doge.jpg");
		Photo crowPhoto = new Photo("CrowOfJudgement.jpg");
		Photo wiretapPhoto = new Photo("HeyWiretap");


		photoService.createOrUpdatePhoto(dogePhoto);
		photoService.createOrUpdatePhoto(crowPhoto);
		photoService.createOrUpdatePhoto(wiretapPhoto);
	}
}
