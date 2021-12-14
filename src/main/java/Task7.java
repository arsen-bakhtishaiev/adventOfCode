import java.util.ArrayList;
import java.util.List;

public class Task7 {

    public static void main( String[] args ) {
        //List<String> bingoData = Utils.readFromFile( "bingoData.txt" );
        List<String> bingoData = Utils.readFromFile( "bingoDataSample.txt" );

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

        int[][][] matchesCounter = new int[listOfBoards.size()][2][5];

        int[][] boardWonOn = new int[listOfBoards.size()][1];


        int boardWon = 0;
        int finalbingoInput = 0;
        outerLoop:
        for ( int currentBingoInput = 0; currentBingoInput < bingoInputs.length; currentBingoInput++ ) {
            int parsedBingoInput = Integer.parseInt( bingoInputs[currentBingoInput] );
            for ( int currentBoardCounter = 0; currentBoardCounter < listOfBoards.size(); currentBoardCounter++ ) {
                int[][] currentBoard = listOfBoards.get( currentBoardCounter );
                boolean boardComplete = false;
                for ( int currentRow = 0; currentRow < 5; currentRow++ ) {
                    for ( int currentColumn = 0; currentColumn < 5; currentColumn++ ) {
                        if ( parsedBingoInput == currentBoard[currentRow][currentColumn] ) {
                            matchesCounter[currentBoardCounter][0][currentRow] =
                                    matchesCounter[currentBoardCounter][0][currentRow] + 1;
                            matchesCounter[currentBoardCounter][1][currentColumn] =
                                    matchesCounter[currentBoardCounter][1][currentColumn] + 1;
                            if ( matchesCounter[currentBoardCounter][0][currentRow] == 5 ||
                                    matchesCounter[currentBoardCounter][1][currentColumn] == 5
                            ) {
                                boardWon = currentBoardCounter;
                                finalbingoInput = currentBingoInput;
                                break outerLoop;
                            }
                        }
                    }
                }
            }
        }

        int winningNumber = Integer.parseInt( bingoInputs[finalbingoInput] );
        int sumOfBoardsValues = 0;
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                int currentValue = listOfBoards.get( boardWon )[i][j];
                for( int valueCounter =0; valueCounter <= finalbingoInput; valueCounter++ ){
                    if( Integer.parseInt( bingoInputs[valueCounter] ) == currentValue){
                        listOfBoards.get( boardWon )[i][j] = 0;
                    }
                }
            }
        }

        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                sumOfBoardsValues = sumOfBoardsValues + listOfBoards.get( boardWon )[i][j];
            }

        }

        System.out.println( "Winning number" + winningNumber + "; Board value " + sumOfBoardsValues + ";" +sumOfBoardsValues * winningNumber);


    }
}


