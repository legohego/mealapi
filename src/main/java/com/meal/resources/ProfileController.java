package com.meal.resources;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meal.models.Profile;
import com.meal.services.ProfileService;


public class ProfileController {


	@Autowired
	public ProfileService profileService;
	@RequestMapping("/Profiles")
	@ResponseBody
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}

	@RequestMapping(method=RequestMethod.GET, value = "/Profile/")
	public Profile getProfile(@RequestParam(value="id", required=true) String id) {
		return profileService.getProfile(id);
	}
	@RequestMapping(method=RequestMethod.POST, value = "/Profile/")
	public void setProfile(@RequestBody Profile Profile){
		profileService.addProfile(Profile);
	}
}
