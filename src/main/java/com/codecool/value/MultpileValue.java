package com.codecool.value;

import java.util.List;

public class MultpileValue extends Value{

    public MultpileValue(List<String> params, boolean selectionType) {
        this.patterns.addAll(params);
        this.selectionType = selectionType;
    }
}
