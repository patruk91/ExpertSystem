package com.codecool.repository;

import com.codecool.data.Question;

import java.util.*;

public class RuleRepository {
    private Map<String, Question> questions;
    private Iterator<Question> iterator;

    public RuleRepository() {
        this.questions = new LinkedHashMap<>();
        this.iterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    public Iterator<Question> getIterator() {
        return iterator;
    }

    private class QuestionIterator implements Iterator<Question> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
                // or return null
            }
//            (Question) questions.values().toArray()[index++];
            index++;
            String keyId = questions.keySet().iterator().next();
            return questions.get(keyId);


        }
    }

}
