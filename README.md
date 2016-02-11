Swiss 'Tournament' Organizer

The tournament organizer(TO) runs a swiss style tournament, a tournament that
plays a certain number of rounds depending on the number of participants in the
tournament, matching participants according to their ranking in each round
without pairing two people together more than once.

Implemented with: Command Line
To be implemented in: Java Swing


::Program Document:: (to be implemented in Swing)

The program starts off with a manager that prompts the user to either create a new tournament,
load a save, or view the results of a past tournament. Starting a new tournament will prompt for more 
specific information regarding it, like date, format, and an optional description for
record keeping purposes. After entering that information, the program will then prompt for
input of names (text field) with a list next to the prompt showing players who have already signed up.
Above the prompt for names will be a drop-down menu of past players for quick access to add players.
A button will be there to finalize the list, displaying an intermediate screen showing the list of 
players with two buttons, one to go back and edit players, and one to start the tournament.
Each match of the round will be represented by a button that will open another window prompt with 
fields for number of wins, losses, and draws. The record will indicate a specific player as the active. 
The next window after starting the tournament will list the pairings for the first round in a 
format where clicking on the match will prompt for the match result. After all the match results are 
entered, a button to conclude the first round will be enabled and pairings for the second round will 
be generated. A timer will be implemented with a start and stop button for limiting the length of the
round. After the requisite number of rounds have been played (determined by the number of 
players), rankings will be listed giving the option for all who are undefeated to play more rounds
of single elimination to determine the end of the tournament. Once the tournament is finished, a
record is saved as a file which can then be reviewed later. Closing the tournament window in the
middle of a tournament will prompt the user to determine whether or not to save the current tournament,
abort closing the window, or to close without saving. 

Adding capability to drop players, having checkboxes on the match result window, as well as an additional
window inbetween rounds listing active players and their rankings.


::Design Document:: (Not accurate over 226 players)

  8 players:  3 rounds

 16 players:  4 rounds

 32 players:  5 rounds

 64 players:  6 rounds

128 players:  7 rounds

256 players:  8 rounds

512 players:  9 rounds

1024 players:  10 rounds


TieBreakers

1. Match points

	a. 3 points for every win

	b. 0 points for every loss

	c. 1 point for every draw

2. Opponent's Match-Win %

	a. avg((match points / (3 * #ofMatches)) || 0.33)

3. Game points

	a. 3 points for every win

	b. 0 points for every loss

	c. 1 point for every draw

4. Opponent's Game-Win %

	a. avg((game points / (3 * #ofGames)) || 0.33)
