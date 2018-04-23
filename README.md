# project3-chess

*About the Rook piece:*
I looked up the official rules for how each piece moves.
 I read that a rook can move forward, backward, left or right.
 The directions on Canvas say that a rook can move only forwards, left, or right.
 My code allows for backwards movement as well since technically the rook can move backwards.
 However, as long as the rook is not moved backwards, it follows the directions from Canvas.

I created my own repository instead of using the one created by Professor Leese.
I added the input file into my own repository, so the other one does not have all the other files.

The coordinates in the input file do not correspond to the coordinates of the 2D array that houses the board.
The arbitrary coordinates given in the input file must be converted. There are two separate methods,
changeXCoordinates(ypos) and changeYCoordinates(xpos) that accomplishes this.
(The x and y positions must be switched, even though it seems confusing)