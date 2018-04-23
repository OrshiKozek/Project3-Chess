# project3-chess

#Orshi Kozek

I created my own repository instead of using the one created by Professor Leese.
I'd already done a lot of work in my own repo, so I decided to stick with this one.
However, I added the input file from the one linked to the top of the canvas assignment to my own repository,
so the other one does not have all the other files.


*About the Rook piece:*
I looked up the official rules for how each piece moves.
 I read that a rook can move forward, backward, left or right.
 The directions on Canvas say that a rook can move only forwards, left, or right.
 My code allows for backwards movement as well since technically the rook can move backwards.
 However, as long as the rook is not moved backwards, it follows the directions from Canvas.

The coordinates in the input file do not correspond to the coordinates of the 2D array that houses the board.
The arbitrary coordinates given in the input file must be converted. There are two separate methods,
changeXCoordinates(xpos) and changeYCoordinates(ypos) that accomplishes this.

In the Pawn class's move method, there is a section that is commented out.
The pawn can only move forward two steps if it is in the sixth row.
This is because in the official set up of chess pieces, the pawns are all in the 6th row.
I commented this part out to fit the input file's data. (There is a pawn that starts in the 7th row.)
I was also unable to make sure that the pawn only moves forward in the first time that it moves.

Pieces can now be moved. I kind of cheated and arbitrarily followed the order of the moved pieces from the input file.
I used this order to move the different pieces around. Therefore the moving code only works for this specific input file.

I still don't entirely understand how exceptions work, so I do not know if my OutOfBoardException is correct.
I didn't have time to create the other exception.