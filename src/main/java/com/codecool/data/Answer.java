package com.codecool.data;

import com.codecool.value.Value;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> values;

    public Answer() {
        this.values = new ArrayList<>();
    }

    public boolean evaluateAnswerByInput(String input) {
        for (Value value : values) {
            System.out.println(value.getInputPattern());
            for (String element : value.getInputPattern()) {
                if (element.equals(input)) {
                    return value.getSelectionType();
                }
            }
        }
        throw new InputMismatchException("Sorry we don't have this answer in our database.");
    }

    public void addValue(Value value) {
        values.add(value);
    }

    public String getValues() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Value value : values) {
            stringBuilder.append(value.getInputPattern());
        }
        return stringBuilder.toString();
    }

}
