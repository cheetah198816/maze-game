"# maze-game"

The test is based on exploring any arbitrary maze (one is provided).

What we are looking from you in this test is to produce a production-quality solution for the given example maze! We are looking
for you to demonstrate your ability to turn a given requirement into a working and well tested software!

In the circumstances that you have questions on the requirement, you are free to make an assumption and make that clear
in a README.txt file that you provide with your project!

As for the technical requirements, the solution MUST be in Java! Feel free to use any build tool and a testing framework
that you are most comfortable with!




User Story 1
------------

As a world famous explorer of Mazes I would like a maze to exist
So that I can explore it

Acceptance Criteria

* A Maze (as defined in example maze in below consists of walls 'X', Empty spaces ' ', one and only one Start point 'S' and
one and only one exit 'F'
* After a maze has been created the number of walls and empty spaces should be available to me
* After a maze has been created I should be able to put in a co ordinate and know what exists at that point




User Story 2
------------

As a world famous explorer of Mazes I would like to exist in a maze and be able to navigate it
So that I can explore it

Acceptance Criteria

* Given a maze the explorer should be able to drop in to the Start point (facing north)
* An explorer on a maze must be able to move forward
* An explorer on a maze must be able to turn left and right (changing direction the explorer is facing)
* An explorer on a maze must be able to declare what is in front of them
* An explorer on a maze must be able to declare all movement options from their given location
* An explorer on a maze must be able to report a record of where they have been in an understandable fashion


Note: We are looking for your Explorer solution to implement the above Acceptance criteria. We do not expect you to submit a fully autonomous maze solving Explorer implementation.


Example Maze:

XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
