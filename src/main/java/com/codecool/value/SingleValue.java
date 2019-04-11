package com.codecool.value;

public class SingleValue extends Value {

    public SingleValue(String param, boolean selectionType) {
        this.selectionType = selectionType;
        this.patterns.add(param);
    }


}
