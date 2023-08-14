package com.demo.profilematcher.services;

import com.demo.profilematcher.entities.Campaign;
import com.demo.profilematcher.entities.Matcher;
import com.demo.profilematcher.entities.Player;
import com.demo.profilematcher.exceptions.ConditionsNotMetException;
import com.demo.profilematcher.exceptions.PlayerNotFoundException;
import com.demo.profilematcher.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Sql({"/data.sql"})
@Service
public class ProfileMatcherServiceImpl implements ProfileMatcherService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player match(String playerId) throws PlayerNotFoundException, ConditionsNotMetException {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);

        Campaign campaign = CampaignMockedService.getMockedCampaign();
        if (optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Player not found!");
        }
        Player player = optionalPlayer.get();

        if (checkConditions(player, campaign)) {
            setActiveCampaignToPlayer(player, campaign);
            return playerRepository.save(player);
        }
        throw new ConditionsNotMetException("Conditions not met!");
    }

    private void setActiveCampaignToPlayer(Player player, Campaign campaign) {
        List<String> playerActiveCampaigns = player.getActiveCampaigns();
        if (playerActiveCampaigns == null) {
            playerActiveCampaigns = new ArrayList<>();
        }
        playerActiveCampaigns.add(campaign.getName());
        player.setActiveCampaigns(playerActiveCampaigns);
    }

    private boolean checkConditions(Player player, Campaign campaign) {
        boolean isLevelMatched = false;
        boolean isCountryMatched = false;
        boolean areItemsMatched = false;

        for (Matcher matcher : campaign.getMatchers()) {
            isLevelMatched = checkLevel(player, matcher);
            isCountryMatched = checkCountry(player, matcher);
            areItemsMatched = checkItems(player, matcher);
        }
        return isLevelMatched && isCountryMatched && areItemsMatched;
    }

    private boolean checkItems(Player player, Matcher matcher) {
        boolean areItemsMatched = false;
        boolean areItemsNotMatched = true;
        List<String> campaignHasItems = matcher.getHas().get("items");
        List<String> campaignDoesNotHaveItems = matcher.getDoesNotHave().get("items");
        for (String playerInventoryKey :
                player.getInventory().keySet()) {
            if (campaignHasItems.contains(playerInventoryKey)) {
                areItemsMatched = true;
            }

            if (campaignDoesNotHaveItems.contains(playerInventoryKey)) {
                areItemsNotMatched = false;
            }
        }
        return areItemsMatched && areItemsNotMatched;
    }

    private boolean checkCountry(Player player, Matcher matcher) {
        List<String> hasCountries = matcher.getHas().get("country");
        return hasCountries.contains(player.getCountry());
    }

    private boolean checkLevel(Player player, Matcher matcher) {
        return matcher.getLevel().getMin() <= player.getLevel()
                && matcher.getLevel().getMax() >= player.getLevel();
    }
}
