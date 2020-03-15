# Schemes-JosephMcG-SEGs-Technical-Test
ConwaysWorld Application, Java

Use Eclipse or Intellij to run this program.

The output will be displayed in your IDE's console,
Simply leave the program running and dont scroll through your console output to see a constant refresh of Conways Game of Life

A random version of Conways Game of life is created upon starting up the program, if you want to test specific cell life cycle 
results simply change the input of any of the test cases.

The Unit tests test the intial input given in the pdf document, as well as results from an empty array and more.


//////////////
MY APPROACH
//////////////

I started out by determining which cells in the array should live or die, looping around each living cell
and setting any dying cells to 2, to ensure they are still factored into the birth of new cells, but then
any cell labeled 2 is then to be deleted later.

The filling array method checks all the possible positions that a new living cell coud be created of already
exsisting cells, horizontally, diagonally, vertically.

The Array is then outputed to the console, 70 lines spaced to give the illusion of a constant refersh with a pause of 7 seconds 
between each new generation.

Possible improvements 

>Include a 2d for-loop in the liveCellChecker method to loop fully around each life cell, as opposed to
 multiple if statements

>More test cases

>More appealing output with a clearer grid-like UI
