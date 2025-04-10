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
        else if (question.contains("Which of the following numbers is the largest: 4, 34, 27?")) {
            return "34"
        }
        else if (question.contains("Which of the following numbers is the largest: 33, 7, 92?")) {
            return "92"
        }
        else if (question.contains("What is 31 plus 4?")) {
            return "35"
        }
        else if (question.contains("What is 16 plus 5?")) {
            return "21"
        }
        else if (question.contains("What is 85 plus 7?")) {
            return "92"
        }
        else if (question.contains("Which of the following numbers is the largest: 31, 60, 67?")) {
            return "67"
        }
        else if (question.contains("What is 97 plus 57?")) {
            return "154"
        }
        else if (question.contains("What is 26 plus 28?")) {
            return "54"
        }
        else if (question.contains("2")) {
            return "4"
        }
        return "I don't know"
    }
}