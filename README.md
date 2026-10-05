# Number Guessing Game

A console-based Number Guessing Game built using Java. The program generates a random secret number based on the selected difficulty level, and the player tries to guess it within a limited number of attempts. It features three difficulty levels, guess history, input validation, replay functionality, and game statistics.

## Features

* Three difficulty levels: Easy, Medium, and Hard
* Random secret number generation based on the selected difficulty level
* Limited attempts based on the selected difficulty level
* Hints indicating whether a guess is too high, too low, or correct
* Displays the remaining attempts after each valid incorrect guess
* Input validation for difficulty selection, guess range, and replay choices
* Guess history showing each valid guess and its result
* Option to play multiple games in one session
* Displays game statistics, including games played, games won, and games lost
* Calculates the win rate based on games played and games won
* Tracks the total number of valid guesses across all games
* Tracks the best game based on the fewest guesses required to win
* Difficulty statistics showing the number of games played at each difficulty level

## Difficulty Levels

| Difficulty | Number Range | Allowed Attempts |
| ---------- | -----------: | ---------------: |
| Easy       |         1–50 |               10 |
| Medium     |        1–100 |                7 |
| Hard       |        1–200 |                5 |

## How It Works

1. The program welcomes the player and prompts them to select a difficulty level.
2. Based on the selected difficulty level, the program determines the number range and the number of allowed attempts.
3. The program generates a random secret number within the selected range.
4. The player enters guesses until they find the secret number or run out of attempts.
5. After each valid guess, the program indicates whether the guess is too high, too low, or correct. For valid incorrect guesses, it also displays the number of attempts remaining.
6. If the player guesses the secret number correctly, the game records a win. Otherwise, it displays the secret number and records a loss.
7. The program displays the guess history, including each valid guess and its result.
8. The player can choose to play again or finish the session.
9. When the player finishes the session, the program displays the overall game statistics and the number of games played at each difficulty level.

## Game Statistics

At the end of the session, the program displays:

* Games played
* Games won
* Games lost
* Win rate
* Total valid guesses across all games
* Best game, based on the fewest guesses required to win

### Difficulty Statistics

* Number of games played at Easy difficulty
* Number of games played at Medium difficulty
* Number of games played at Hard difficulty

**Note:** Invalid guesses outside the allowed number range are rejected and do not count as attempts or appear in the guess history.

## Java Concepts Practiced

* Conditional statements (`if-else`)
* Loops (`while` and `do-while`)
* Switch expressions
* Methods and method parameters
* Return values from methods
* Arrays
* Strings and string methods
* Type casting
* `Scanner` class for user input
* `Random` class for random number generation
* Input validation

## How to Run

1. Make sure Java (JDK) is installed on your computer.
2. Clone or download this repository.
3. Open the project in IntelliJ IDEA or another Java-compatible IDE.
4. Open `NumberGuessingGame.java`.
5. Run the program and follow the instructions displayed in the console.

## Example Output

```text
-------------------------------------
Welcome to the Number Guessing Game!
-------------------------------------

Choose the difficulty level (Easy/Medium/Hard): Easy

You have 10 attempts to guess the number.

Guess a number (1-50): 25
Too High! Try a lower number.
You have 9 attempts left to guess the number.

Guess a number (1-50): 20
Too Low! Try a higher number.
You have 8 attempts left to guess the number.

Guess a number (1-50): 22
Too Low! Try a higher number.
You have 7 attempts left to guess the number.

Guess a number (1-50): 23
Correct! You guessed the number!

You won!

Guess History:
25 -> Too High
20 -> Too Low
22 -> Too Low
23 -> Correct

Would you like to play again? (Yes/No): No

---------------------------
	GAME STATISTICS
---------------------------
Games Played: 1
Games Won: 1
Games Lost: 0
Win Rate: 100.00%
Total Guesses: 4
Best Game: 4 guesses

DIFFICULTY STATISTICS
Easy Games: 1
Medium Games: 0
Hard Games: 0
---------------------------

Thanks for playing!
```

*Note: The output is illustrative. The secret number and game results will vary with each playthrough.*