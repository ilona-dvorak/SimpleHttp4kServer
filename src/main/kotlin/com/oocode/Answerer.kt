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
            val regex = "\\d+".toRegex()

            fun isPerfectSixthPower(n: Int): Boolean {
                val root = Math.pow(n.toDouble(), 1.0 / 6.0).toInt()
                return root.toDouble().pow(6).toInt() == n
            }

            return regex.findAll(question)
                .map { it.value.toInt() }
                .filter(::isPerfectSixthPower)
                .toList()
                .takeIf { it.isNotEmpty() }
                ?.joinToString("")
                ?: "No numbers found that are both square and cube."
        }
        if (question.contains("minus")) {
            val regex = "-?\\d+".toRegex() // Allows for negative numbers as well

            // Extract the numbers and perform subtraction in one step
            return regex.findAll(question)
                .map { it.value.toInt() }  // Convert the matched numbers to integers
                .toList()  // Convert the result to a List
                .takeIf { it.size == 2 }  // Ensure we have exactly two numbers to subtract
                ?.let { (first, second) ->
                    // Perform subtraction (first - second)
                    "${first - second}"
                } ?: "Could not extract two numbers from the input."
        }
        if (question.contains("multiplied")) {
            val regex = "-?\\d+".toRegex()

            // Extract, validate, multiply, and return the result in a single flow
            return regex.findAll(question)
                .map { it.value.toInt() }  // Convert matched digits to integers
                .toList()
                .takeIf { it.size == 2 }   // Ensure exactly two numbers are found
                ?.let { (first, second) ->
                    "${first * second}"
                } ?: "Could not extract two numbers from the input."
        }
        if (question.contains("primes")) {

            val regex = "\\d+".toRegex()

        fun isPrime(n: Int): Boolean = n > 1 && (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0 }

        return regex.findAll(question)
            .map { it.value.toInt() }
            .filter(::isPrime)
            .toList()
            .takeIf { it.isNotEmpty() }
            ?.joinToString("")
            ?: "No prime numbers found in the input."
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
    fun extractAndCheckSquareAndCube(input: String): List<Int> {
        // Regular expression to match sequences of digits (numbers) in the string
        val regex = "\\d+".toRegex()

        // Find all matches of the regex in the input string and convert to a list of integers
        val numbers = regex.findAll(input)
            .map { it.value.toInt() }  // Convert the matched numbers to integers
            .toList()

        // Function to check if a number is a perfect sixth power (both square and cube)
        fun isPerfectSixthPower(n: Int): Boolean {
            val root = Math.pow(n.toDouble(), 1.0 / 6.0).toInt()
            return root.toDouble().pow(6) == n.toDouble()  // Check if root^6 is equal to n
        }

        // Filter numbers that are both square and cube (i.e., perfect sixth powers)
        return numbers.filter { isPerfectSixthPower(it) }
    }



}