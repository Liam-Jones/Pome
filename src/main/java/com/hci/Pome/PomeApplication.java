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
		List<Tag> dogeTags = Arrays.asList(new Tag("Doge"), new Tag("MuchSurprise"));
		List<Tag> crowTags = Arrays.asList(new Tag("Crow"), new Tag("JUDGEMENT"));
		List<Tag> wiretapTags = Arrays.asList(new Tag("Wiretap"));

		Photo dogePhoto = new Photo("doge.jpg", dogeTags);
		Photo crowPhoto = new Photo("CrowOfJudgement.jpg", crowTags);
		Photo wiretapPhoto = new Photo("HeyWiretap.jpg", wiretapTags);

		photoService.createOrUpdatePhoto(dogePhoto);
		photoService.createOrUpdatePhoto(crowPhoto);
		photoService.createOrUpdatePhoto(wiretapPhoto);


		//Todo: Enforce uniqueness
		//List<Photo> memePhotos = Arrays.asList(dogePhoto, crowPhoto, wiretapPhoto);
		//Tag memeTag = new Tag("Meme", memePhotos);

		//tagService.createOrUpdateTag(memeTag);
	}
}
