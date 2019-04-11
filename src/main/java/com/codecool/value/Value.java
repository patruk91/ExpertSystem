package com.codecool.value;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    boolean selectionType;
    List<String> patterns = new ArrayList<>();

    public boolean getSelectionType() {
        return selectionType;
    }

    public List<String> getInputPattern() {
        return patterns;
    }

}
