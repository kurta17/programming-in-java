package com.harbourspace.lesson06;

import java.util.Optional;

public class OptionalTask {

    public static Optional<String> getWord(String text, String word) {
        // Check if the text contains the given word
        if (text.contains(word)) {
            return Optional.of(word);
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        String text = "This is a sample text containing the word Java.";
        String wordToFind = "Java";

        Optional<String> result = getWord(text, wordToFind);

        // Print the result based on the presence of the word
        if (result.isPresent()) {
            System.out.println("Word found: " + result.get());
        } else {
            System.out.println("Word not found: " + wordToFind);
        }
    }
}

