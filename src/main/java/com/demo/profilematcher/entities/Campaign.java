package com.demo.profilematcher.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    private String game;
    private String name;
    private Double priority;
    private List<Matcher> matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean enabled;
    private LocalDateTime lastUpdated;

}