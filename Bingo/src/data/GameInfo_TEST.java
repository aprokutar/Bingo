package data;

public class GameInfo_TEST {
	public static void main(String[] args) {
		
		/* {   "2",   "3",   "4",   "6",  "7" }, 
		   {  "10",   "5",  "30",  "11",  "12" },
		   {  "58",  "57",  "56",  "55",  "54" }, 
		   { "111", "112", "113", "114", "115" }, 
		   {  "21",  "22",  "23",  "24",  "25" } */
		GameInfo gi = new GameInfo();
		/*gi.markBingoResult("21");gi.markBingoResult("22");gi.markBingoResult("28");
		gi.markBingoResult("111");gi.markBingoResult("58");gi.markBingoResult("10");
		gi.markBingoResult("112");gi.markBingoResult("56");gi.markBingoResult("11");
		gi.markBingoResult("7");gi.markBingoResult("25");gi.markBingoResult("56");
		gi.markBingoResult("114");gi.markBingoResult("5");gi.markBingoResult("23");
		gi.markBingoResult("24");gi.markBingoResult("3");gi.markBingoResult("4");
		gi.markBingoResult("6");gi.markBingoResult("30");gi.markBingoResult("12");
		gi.markBingoResult("57");gi.markBingoResult("55");gi.markBingoResult("54");
		gi.markBingoResult("113");gi.markBingoResult("115");gi.markBingoResult("2");*/
		
		gi.markBingoResult("7");
		int[][] result = gi.getBingoResult();
		
		for(int i = 0; i<5 ;i ++){
			for(int j = 0; j<5;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("ÃÑ :"+ gi.checkBingo()+"°³ÀÇ ºù°í!");
	}
}
