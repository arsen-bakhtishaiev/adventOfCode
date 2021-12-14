import java.util.ArrayList;
import java.util.List;

public class Task9 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "linesSample.txt" );
        List<String> linesList = Utils.readFromFile( "lines.txt" );


        int[][][] vectors = new int[linesList.size()][2][2];

        for( int counter = 0; counter < linesList.size(); counter++){
            String vectorsString = linesList.get( counter );
            String[] listOfPoints = vectorsString.split( " -> " );
            String[] startPoints = listOfPoints[0].split( "," );
            String[] endPoints = listOfPoints[1].split( "," );
            vectors[counter][0][0] = Integer.parseInt( startPoints[0] );
            vectors[counter][0][1] = Integer.parseInt( startPoints[1] );
            vectors[counter][1][0] = Integer.parseInt( endPoints[0] );
            vectors[counter][1][1] = Integer.parseInt( endPoints[1] );
        }

        List<int[][]> vectorsList = new ArrayList<>();

        int biggestX = 0;
        int biggestY = 0;

        for(int counter = 0; counter < vectors.length; counter++){
            if ( vectors[counter][0][0] == vectors[counter][1][0]
            || vectors[counter][0][1] == vectors[counter][1][1]){
                int[][] vector = new int[2][2];
                vector[0][0] = vectors[counter][0][0];
                vector[0][1] = vectors[counter][0][1];
                vector[1][0] = vectors[counter][1][0];
                vector[1][1] = vectors[counter][1][1];
                vectorsList.add( vector );

                biggestX = biggestX < vector[0][0] ? vector[0][0] : biggestX;
                biggestY = biggestY < vector[0][1] ? vector[0][1] : biggestY;
            }
        }

        int[][] pointsMap = new int[biggestX + 1][biggestY + 1];

        for ( int counter = 0; counter < vectorsList.size(); counter++ ) {
            int[][] vector = vectorsList.get( counter );
            if ( vector[0][0] == vector[1][0] ){
                int startY = vector[0][1] < vector[1][1] ? vector [0][1] : vector[1][1];
                int endY = vector[0][1] < vector[1][1] ? vector [1][1] : vector[0][1];
                for(int counterY = startY; counterY <= endY; counterY++){
                    pointsMap[vector[0][0]][counterY] = pointsMap[vector[0][0]][counterY] + 1;
                }
            }else if ( vector[0][1]==vector[1][1] ){
                int startX = vector[0][0] < vector[1][0] ? vector [0][0] : vector[1][0];
                int endX = vector[0][0] < vector[1][0] ? vector [1][0] : vector[0][0];
                for(int counterX = startX; counterX <= endX; counterX++){
                    pointsMap[counterX][vector[0][1]] = pointsMap[counterX][vector[0][1]] + 1;
                }
            }
        }

        int counterOfDangerous = 0;
        for ( int x = 0; x <= biggestX; x++ ) {
            for ( int y = 0; y <= biggestY; y++ ) {
                if(pointsMap[x][y] >= 2 ){
                    counterOfDangerous++;
                }
            }
        }

        for ( int[] x : pointsMap ){
            String pointsString = "";
            for ( int point: x ){
                 pointsString = pointsString + "," + point;
            }
            System.out.println( pointsString );
        }
        System.out.println( counterOfDangerous);
    }
}


