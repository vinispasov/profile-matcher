package com.demo.profilematcher.controllers;

import com.demo.profilematcher.exceptions.ConditionsNotMetException;
import com.demo.profilematcher.exceptions.PlayerNotFoundException;
import com.demo.profilematcher.services.ProfileMatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile-matcher")
public class ProfileMatcherController {

    @Autowired
    private ProfileMatcherService profileMatcherService;

    @GetMapping("/{playerId}")
    public ResponseEntity getPlayerById(@PathVariable("playerId") String playerId) {
        try {
            return ResponseEntity.ok().body(profileMatcherService.match(playerId));
        } catch (PlayerNotFoundException | ConditionsNotMetException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
