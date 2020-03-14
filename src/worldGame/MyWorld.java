package worldGame;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
public class MyWorld {
	
	static int genCount = 1;
	public static void main(String[] args) throws InterruptedException
	{
		int[][] arrayIn = {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 1, 0, 0, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				};

		int m=10;
		int n=10;

		printingCells(arrayIn);
		
		/*
		 * System.out.println("Starting generation 1");
		 * 
		 * for(int i=0; i<m; i++) { for(int j=0; j<n; j++)
		 * 
		 * { //System.out.print(arrayIn[i][j]);
		 * 
		 * if(arrayIn[i][j]==1) { // System.out.print("*"); System.out.print("1");
		 * 
		 * } else { System.out.print("0"); }
		 * 
		 * } System.out.println(""); }
		 */
		 
		 sleepAndClear();
		
		
		
		while(true==true)
		{
		
		myWorldCreator(arrayIn);
		sleepAndClear();

		}
	}
	
	
	public static void myWorldCreator(int[][]grid) {

		 int m = 10;
		 int n = 10;
		 
		 for(int i=0; i<m; i++)
		 {
			 int liveCellCount=0;
			 
			 for(int j=0; j<n; j++)	 
			 {
				 
				 if(grid[i][j]==1)
				 {
					
					 liveCellChecker(grid, i, j,liveCellCount);
					 
					 liveCellCount=0;

					 fillingTheArray(grid, i, j);
					 
				 }
			 }
		 }
		 
		 printingCells(grid);
	
	 
	}
	
	public static void liveCellChecker2(int arr[][], int ii, int jj, int liveCheck)
	{
		
		for(int ai= -1; ai<=1; ai++)
		{
			for(int aj=-1; aj<=1; aj++)
			{
				
				if(arr[ai][aj]==1 || arr[ai][aj]==2)
				{
					
				}
				
			}
		}
		
	} 
	
	
	public static void liveCellChecker(int arr[][], int ii, int jj, int liveCheck)
	{
		//DOES THE LIVE CELL LIVE OR DIE?
    	//THIS IS SEARCHING AROUND THE CELL CLOCKWISE 
		
		int size=10;
	 
		if((ii-1)>=0)
		{	
			//  0?0
			//  010
			//  000
			
				 if(arr[ii-1][jj]==1 || arr[ii-1][jj]==2)
				 {
					 liveCheck++;
				 }
		
		 if(jj+1<size)
		  {
				//  00?
				//  010
				//  000
				 if(arr[ii-1][jj+1]==1 || arr[ii-1][jj+1]==2 )
				 {
					 liveCheck++;
				 }
		  }
		}	 
		
		
		 if(jj+1<size)
	     {
				//  000
				//  01?
				//  000
				 if(arr[ii][jj+1]==1 ||arr[ii][jj+1]==2)
				 {
					 liveCheck++;
				 } 
				 
		  if(ii+1<size)
		    {
				//  000
				//  010
				//  00?
		 		 if(arr[ii+1][jj+1]==1 || arr[ii+1][jj+1]==2)
				 {
		 			liveCheck++;
				 }
		    }	 
		  
	    }
		 
		 if(ii+1<size)
		    {
				//  000
				//  010
				//  0?0
				 if(arr[ii+1][jj]==1 || arr[ii+1][jj]==2)
				 {
					 liveCheck++;

				 }
		     if(jj-1>=0)
		     {
		    		//  000
					//  010
					//  ?00
				 if(arr[ii+1][jj-1]==1 ||arr[ii+1][jj-1]==2)
				 {
					 liveCheck++;

				 }
		     } 
				 
		    }
		 
		 
		 if(jj-1>=0)
	     {
				//  000
				//  ?10
				//  000
				 
				 if(arr[ii][jj-1]==1 ||arr[ii][jj-1]==2)
				 {
					 liveCheck++;

				 }
				 
		   if(ii-1>=0)
		   {	 
			    //  ?00
				//  010
				//  000
				 if(arr[ii-1][jj-1]==1 ||arr[ii-1][jj-1]==2)
				 {
					 liveCheck++;

				 }
		   } 
	     }	 
				 
				//Lives with population of 2 or 3
			
				 if(liveCheck==2||liveCheck==3)
				 {
					 arr[ii][jj]=1;
				 }
				//Dies of under-population or over-population 

				 else
				 {
					 arr[ii][jj]=2;
				 }
		
	}
	
	public static void fillingTheArray(int arr[][], int ii, int jj)
	{
		int size = 10;

		// FILLING ARRAY HORIZONTALLY

		if (jj + 2 < size) {
			if (ii - 1 >= 0) {
				// 030
				// .111
				//
				if ((arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2) && (arr[ii][jj + 2] == 1 || arr[ii][jj + 2] == 2)
						&& (arr[ii - 1][jj + 1] == 0)) {
					arr[ii - 1][jj + 1] = 3;

				}

			}

			if (ii + 1 < size) {
				// below 111
				// .030
				//

				if ((arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2) && (arr[ii][jj + 2] == 1 || arr[ii][jj + 2] == 2)
						&& (arr[ii + 1][jj + 1] == 0)) {
					arr[ii + 1][jj + 1] = 3;
				}
			}

		}

		//
		// FILLING ARRAY VERTICALLY
		//

		if (ii - 2 >= 0) {
			// 1
			// 31
			// .1
			if (jj - 1 >= 0) {

				if ((arr[ii - 1][jj] == 1 || arr[ii - 1][jj] == 2) && (arr[ii - 2][jj] == 1 || arr[ii - 2][jj] == 2)
						&& (arr[ii - 1][jj - 1] == 0)) {
					arr[ii - 1][jj - 1] = 3;

				}
			}

			// 1
			// 13
			// .1

			if (jj + 1 < size) {

				if ((arr[ii - 1][jj] == 1 || arr[ii - 1][jj] == 2) && (arr[ii - 2][jj] == 1 || arr[ii - 2][jj] == 2)
						&& (arr[ii - 1][jj + 1] == 0)) {
					arr[ii - 1][jj + 1] = 3;

				}
			}
		}

		//
		// FILLING ARRAY ADJACENT
		//

		if (ii - 1 >= 0 && jj + 1 < size)

		{

			// 10
			//.11
			//

			if ((arr[ii - 1][jj] == 1 || arr[ii - 1][jj] == 2) && (arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2)
					&& (arr[ii - 1][jj + 1] == 0)) {

				arr[ii - 1][jj + 1] = 3;

			}

			//
			//    01
			//   .11

			if ((arr[ii - 1][jj + 1] == 1 || arr[ii - 1][jj + 1] == 2) && (arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2)
					&& (arr[ii - 1][jj] == 0)) {
				arr[ii - 1][jj] = 3;

			}

			//  11
			// .10

			if ((arr[ii - 1][jj] == 1 || arr[ii - 1][jj] == 2) && (arr[ii - 1][jj + 1] == 1 || arr[ii - 1][jj + 1] == 2)
					&& (arr[ii][jj + 1] == 0)) {

				arr[ii][jj + 1] = 3;

			}
		}

	 
		  //check below it //
		  //.11 
		  // 01
		  

		if (ii + 1 < size && jj + 1 < size) {

			if ((arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2) && (arr[ii + 1][jj + 1] == 1 || arr[ii + 1][jj + 1] == 2)
					&& (arr[ii + 1][jj] == 0)) {
				arr[ii + 1][jj] = 3;

			}

		  // check below again // 
		  //.11 
		  // 10

			if ((arr[ii][jj + 1] == 1 || arr[ii][jj + 1] == 2) && (arr[ii + 1][jj] == 1 || arr[ii + 1][jj] == 2)
					&& (arr[ii + 1][jj + 1] == 0)) {
				arr[ii + 1][jj + 1] = 3;
			}
		}

	}
	
	public static void printingCells(int[][]arr)
	{
	

		 System.out.println("Current Cell Life of generation " + genCount + "\n" + "----------");

		 genCount++;
		 
		 for(int ii=0; ii<10; ii++)
		 {
						 
			 for(int jj=0; jj<10; jj++)
				 
			 {
				 if(arr[ii][jj]==2)
				 {
					 arr[ii][jj]=0;

				 }
				 
				 if(arr[ii][jj]==3)
				 {
					 arr[ii][jj]=1;

				 }
				
					 System.out.print(arr[ii][jj]);
				 
			 }
			 System.out.println("");
		 }
		 
		 System.out.println("----------");
	}
	
	
public static void sleepAndClear() throws InterruptedException
	{
		//Pauses the output for 7 seconds and 
		//spaces 70 characters out from the last output
		//in the console
		TimeUnit.SECONDS.sleep(7);
		System.out.println(new String(new char[70]).replace("\0", "\r\n"));
	}
	
	
	}
