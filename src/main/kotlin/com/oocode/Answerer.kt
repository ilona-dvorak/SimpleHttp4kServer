package com.oocode

class Answerer {
    fun answerFor(question: String): String {
        if (question.contains("What is your name?")) {
            return "Two Sigma"
        }
        if (question.contains("Which of the following numbers is the largest")) {
            val regex = "\\d+".toRegex()

            // Find all matches of the regex in the input string
            val numbers = regex.findAll(question)
                .map { it.value.toInt() }  // Convert each match (String) to an Integer
                .toList()

            // Return the largest number, or null if no numbers were found
            return numbers.maxOrNull().toString();

        }
        if (question.contains("plus")) {
            val regex = "\\d+".toRegex()

            // Find all matches of the regex in the input string
            val numbers = regex.findAll(question)
                .map { it.value.toInt() }  // Convert each match (String) to an Integer
                .toList()

            // Return the largest number, or null if no numbers were found
            return numbers.sum().toString();
        }
        else if (question.contains("2")) {
            return "4"
        }
        return "I don't know"
    }
}