package com.codecool.repository;

import com.codecool.data.Fact;
import com.codecool.data.Question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FactRepository {
    private List<Fact> facts;
    private Iterator<Fact> iterator;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.iterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return iterator;
    }

    private class FactIterator implements Iterator<Fact> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < facts.size();
        }

        @Override
        public Fact next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
                // or return null
            }
//            (Question) questions.values().toArray()[index++];
            return facts.get(index++);
        }
    }
}
