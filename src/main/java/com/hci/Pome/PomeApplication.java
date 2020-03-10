package com.hci.Pome;

import com.hci.Pome.entities.Photo;
import com.hci.Pome.entities.Tag;
import com.hci.Pome.services.PhotoService;
import com.hci.Pome.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PomeApplication implements CommandLineRunner{

	@Autowired
	PhotoService photoService;

	@Autowired
	TagService tagService;

	public static void main(String[] args) {
		SpringApplication.run(PomeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Tag> dogeTags = Arrays.asList(new Tag("Doge"));
		List<Tag> crowTags = Arrays.asList(new Tag("Crow"));
		List<Tag> wiretapTags = Arrays.asList(new Tag("Wiretap"));
		List<Tag> catTags = Arrays.asList(new Tag("Cat"));
		List<Tag> acadia1Tags = Arrays.asList(new Tag("Acadia_Hill"));
		List<Tag> sky1Tags = Arrays.asList(new Tag("Purple_Sky"));
		List<Tag> flower1Tags = Arrays.asList(new Tag("Yellow_Flower"));
		List<Tag> vector1Tags = Arrays.asList(new Tag("Brain_Drawing"));
		List<Tag> ls2Tags = Arrays.asList(new Tag("Beach"));

		Photo dogePhoto = new Photo("doge.jpg", dogeTags);
		Photo crowPhoto = new Photo("CrowOfJudgement.jpg", crowTags);
		Photo wiretapPhoto = new Photo("HeyWiretap.jpg", wiretapTags);
		Photo catPhoto = new Photo("animal1.jpg", catTags);
		Photo acadia1Photo = new Photo("acadia1.jpg", acadia1Tags);
		Photo sky1Photo = new Photo("sky2.jpg", sky1Tags);
		Photo flower1Photo = new Photo("flower2.jpg", flower1Tags);
		Photo vector1Photo = new Photo("brain_vector.jpg", vector1Tags);
		Photo ls2Photo = new Photo("landscape3.jpg", ls2Tags);

		photoService.createOrUpdatePhoto(catPhoto);
		photoService.createOrUpdatePhoto(dogePhoto);
		photoService.createOrUpdatePhoto(wiretapPhoto);
		photoService.createOrUpdatePhoto(acadia1Photo);
		photoService.createOrUpdatePhoto(crowPhoto);
		photoService.createOrUpdatePhoto(sky1Photo);
		photoService.createOrUpdatePhoto(vector1Photo);
		photoService.createOrUpdatePhoto(ls2Photo);
		photoService.createOrUpdatePhoto(flower1Photo);


		//Todo: Enforce uniqueness
		//List<Photo> memePhotos = Arrays.asList(dogePhoto, crowPhoto, wiretapPhoto);
		//Tag memeTag = new Tag("Meme", memePhotos);

		//tagService.createOrUpdateTag(memeTag);
	}
}
