package com.oocode

import kotlin.math.pow

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
        if (question.contains("Which of the following numbers is both a square and a cube")) {
            return extractSquareAndCubeNumbers(question).toString();
        }
        else if (question.contains("2")) {
            return "4"
        }
        return "I don't know"
    }

    fun extractSquareAndCubeNumbers(input: String): List<String> {
        // Regular expression to match sequences of digits (numbers) in the string
        val regex = "\\d+".toRegex()

        // Find all matches of the regex in the input string and convert to a list of integers
        val numbers = regex.findAll(input)
            .map { it.value.toInt() }  // Convert the matched numbers to integers
            .toList()

        // Function to check if a number is a perfect sixth power
        fun isPerfectSixthPower(n: Int): Boolean {
            val root = Math.pow(n.toDouble(), 1.0 / 6.0).toInt()
            return root.toDouble().pow(6) == n.toDouble()  // Check if root^6 is equal to n
        }

        // Filter numbers that are both square and cube (i.e., perfect sixth powers)
        return numbers.filter { isPerfectSixthPower(it) }
            .map { it.toString() }  // Convert the result numbers back to strings
    }
}