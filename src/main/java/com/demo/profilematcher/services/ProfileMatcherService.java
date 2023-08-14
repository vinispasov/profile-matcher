package com.demo.profilematcher.services;

import com.demo.profilematcher.entities.Player;
import com.demo.profilematcher.exceptions.ConditionsNotMetException;
import com.demo.profilematcher.exceptions.PlayerNotFoundException;

public interface ProfileMatcherService {

    Player match(String playerId) throws PlayerNotFoundException, ConditionsNotMetException;
}
