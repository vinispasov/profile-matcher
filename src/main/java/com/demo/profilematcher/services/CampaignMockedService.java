package com.demo.profilematcher.services;

import com.demo.profilematcher.entities.Campaign;
import com.demo.profilematcher.entities.Level;
import com.demo.profilematcher.entities.Matcher;

import java.time.LocalDateTime;
import java.util.*;

public class CampaignMockedService {

    public static Campaign getMockedCampaign() {
        Map<String, List<String>> has = new HashMap<>();
        List<String> countries = new ArrayList<>();
        List<String> items = new ArrayList<>();
        Level level = new Level();

        Map<String, List<String>> doesNotHave = new HashMap<>();
        List<String> items1 = new ArrayList<>();

        Random random = new Random();

        if (random.nextInt() % 2 == 0) {
            countries.add("US");
            countries.add("RO");
            countries.add("CA");
            items.add("item_1");
            has.put("country", countries);
            has.put("items", items);

            items1.add("item_4");
            doesNotHave.put("items", items1);

            level.setMin(1);
            level.setMax(3);
        } else {
            countries.add("BG");
            items.add("item_21");
            has.put("country", countries);
            has.put("items", items);

            items1.add("item_1");
            doesNotHave.put("items", items1);

            level.setMin(2);
            level.setMax(2);
        }
        List<Matcher> matchers = new ArrayList<>();
        matchers.add(new Matcher(level, has, doesNotHave));

        UUID uuid = UUID.randomUUID();
        return new Campaign("game_" + uuid, "name_" + uuid, 1.0, matchers, LocalDateTime.now(), LocalDateTime.now().plusDays(1), true, LocalDateTime.now());
    }
}
