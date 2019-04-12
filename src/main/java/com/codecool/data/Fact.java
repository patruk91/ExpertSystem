package com.codecool.data;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String id;
    private String  description;
    private Map<String, Boolean> facts;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.facts = new LinkedHashMap<>();
    }

    public Set<String> getIdSet() {
        Set<String> idSet = new LinkedHashSet<>();
        for (String keys : facts.keySet()) {
            idSet.add(keys);
        }
        return idSet;
    }

    public void setFactValueById(String id, boolean value) {
        facts.put(id, value);
    }


    public Boolean getValueById(String id) {
        return facts.get(id);
    }

    public String getDescription() {
        return description;
    }
}
