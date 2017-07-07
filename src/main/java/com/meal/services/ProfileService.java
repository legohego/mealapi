package com.meal.services;

import java.util.List;

import com.meal.models.Profile;

public interface ProfileService {

	List<Profile> getProfiles();

	Profile getProfile(String id);

	void addProfile(Profile profile);

}
