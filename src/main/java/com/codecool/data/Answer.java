package com.codecool.data;

import com.codecool.value.Value;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Value> values;

    public Answer() {
        this.values = new ArrayList<>();
    }

    public boolean evaluateAnswerByInput(String input) {
        for (Value value : values) {
            for (String element : value.getInputPattern()) {
                if (element.equals(input)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }
}
