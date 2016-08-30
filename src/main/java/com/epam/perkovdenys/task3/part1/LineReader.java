package com.epam.perkovdenys.task3.part1;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LineReader implements Iterable {

    private String name;

    public LineReader(String name) {
        this.name = name;
    }

    @Override
    public Iterator<String> iterator() {
        return new LineIterator();
    }

    class LineIterator implements Iterator<String> {

        private Scanner fileReader;

        public LineIterator() {
            try {
                fileReader = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            try {
                if (fileReader == null) {
                    return false;
                }
                if (fileReader.hasNextLine()) {
                    return true;
                }
                fileReader.close();
                return false;
            } catch (IllegalStateException e) {
                return false;
            }
        }

        @Override
        public String next() {
            try {
                if (fileReader == null || !fileReader.hasNextLine()) {
                    throw new NoSuchElementException();
                }
                return fileReader.nextLine();
            } catch (IllegalStateException e) {
                throw new NoSuchElementException();
            }
        }
    }
}