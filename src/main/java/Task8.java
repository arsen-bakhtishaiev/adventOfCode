import java.util.ArrayList;
import java.util.List;

public class Task8 {

    public static void main( String[] args ) {
//        List<String> bingoData = Utils.readFromFile( "bingoDataSample.txt" );
        List<String> bingoData = Utils.readFromFile( "bingoData.txt" );

        String[] bingoInputs = bingoData.get( 0 ).split( "," );

        List<int[][]> listOfBoards = new ArrayList<>();

        int counter = 0;
        for ( int stringCounter = 1; stringCounter < bingoData.size(); stringCounter++ ) {
            String bingoBoardString = bingoData.get( stringCounter );
            if(bingoBoardString.indexOf( "," ) != -1 ){
                continue;
            }
            if ( bingoBoardString.isEmpty() ) {
                counter = 0;
                listOfBoards.add( new int[5][5] );
                continue;
            }
            String[] parsedString = bingoBoardString.trim().split( "\\s+" );
            for ( int i = 0; i < 5; i++ ) {
                listOfBoards.get( listOfBoards.size() -1 )[counter][i]= Integer.parseInt( parsedString[i].trim() );
            }

            counter++;
        }

        int finalbingoInput = 0;
        int lastValueToWin = 0;
        int lastBoardToWin = 0;
        int bingoWinningCOunter = 0;
        for ( int currentBoardCounter = 0; currentBoardCounter < listOfBoards.size(); currentBoardCounter++ ) {
            int[][] currentBoard = listOfBoards.get(currentBoardCounter);
            int[][] matchesCounter = new int [2][5];
            outerLoop:
            for ( int currentBingoInput = 0; currentBingoInput < bingoInputs.length; currentBingoInput++ ) {
                int parsedBingoInput = Integer.parseInt( bingoInputs[currentBingoInput] );
                for ( int currentColumn = 0; currentColumn < 5; currentColumn++ ) {
                    for ( int currentRow = 0; currentRow < 5; currentRow++ ) {
                        if ( parsedBingoInput == currentBoard[currentRow][currentColumn] ) {
                            matchesCounter[0][currentColumn] = matchesCounter[0][currentColumn] + 1;
                            matchesCounter[1][currentRow] = matchesCounter[1][currentRow] + 1;
                            if ( matchesCounter[0][currentColumn] == 5 || matchesCounter[1][currentRow] == 5 ){
                                if( bingoWinningCOunter < currentBingoInput){
                                    bingoWinningCOunter = currentBingoInput;
                                    lastBoardToWin = currentBoardCounter;
                                    lastValueToWin = parsedBingoInput;
                                }
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }


        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                int currentValue = listOfBoards.get( lastBoardToWin )[i][j];
                for( int valueCounter =0; valueCounter <= bingoWinningCOunter; valueCounter++ ){
                    if( Integer.parseInt( bingoInputs[valueCounter] ) == currentValue){
                        listOfBoards.get( lastBoardToWin )[i][j] = 0;
                    }
                }
            }
        }

        int sumOfBoardsValues = 0;
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                sumOfBoardsValues = sumOfBoardsValues + listOfBoards.get( lastBoardToWin )[i][j];
            }

        }

        System.out.println( "Winning number" + lastValueToWin + "; Board value " + sumOfBoardsValues + ";" +sumOfBoardsValues * lastValueToWin);


    }
}


