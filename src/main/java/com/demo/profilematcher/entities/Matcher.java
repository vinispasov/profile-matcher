package com.demo.profilematcher.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matcher {
    private Level level;
    private Map<String, List<String>> has;
    private Map<String, List<String>> doesNotHave;
}
