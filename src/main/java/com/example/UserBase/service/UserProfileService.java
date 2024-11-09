package com.example.UserBase.service;

import com.example.UserBase.entity.UserProfile;
import com.example.UserBase.repos.UserProfRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class UserProfileService {

    private final UserProfRepos userProfileRepository;
    public Optional<UserProfile> getUserProfile(Long id) {
        return userProfileRepository.findById(id);
    }



    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }
    public UserProfile updateUserProfile(Long id, UserProfile updateUser) {
        UserProfile existingProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserProfile not found with id " + id));
        existingProfile.setBirthYear(updateUser.getBirthYear());
        existingProfile.setAbout(updateUser.getAbout());
        existingProfile.setUser(updateUser.getUser());

        return userProfileRepository.save(existingProfile);
    }

    public UserProfile createUserProfile(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

}