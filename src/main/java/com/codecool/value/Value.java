package com.codecool.value;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    boolean selectionType;
    List<String> patterns = new ArrayList<>();

    protected boolean getSelectionType() {
        return selectionType;
    }

    protected List<String> getInputPattern() {
        return patterns;
    }

}
