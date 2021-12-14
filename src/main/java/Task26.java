import java.util.*;
import java.util.stream.Collectors;

public class Task26 {
    public static void main( String[] args ) {
//        List<String> dotsList = Utils.readFromFile( "dotsSample.txt" );
        List<String> dotsList = Utils.readFromFile( "dots.txt" );

        List<int[]> dots = new ArrayList<>();
        List<String> folds = new ArrayList<>();
        boolean isDots = true;
        int maxX = 0;
        int maxY = 0;
        for ( String string : dotsList ) {
            if ( isDots ) {
                if ( string.isEmpty() ) {
                    isDots = false;
                } else {
                    String[] coords = string.split( "," );
                    int currentX = Integer.parseInt( coords[0] );
                    int currentY = Integer.parseInt( coords[1] );

                    maxX = maxX > currentX ? maxX : currentX;
                    maxY = maxY > currentY ? maxY : currentY;

                    int[] dot = new int[]{ currentX, currentY };
                    dots.add( dot );
                }
            } else {
                folds.add( string );
            }
        }

        int[][] arrayWithDots = new int[maxY + 1][maxX + 1];
        for ( int[] dot : dots ) {
            arrayWithDots[dot[1]][dot[0]] = 1;
        }

        List<List<Integer>> listWithDots = new ArrayList<>();

        for ( int y = 0; y < arrayWithDots.length; y++ ) {
            String s = "";
            List<Integer> string = new ArrayList<>();
            for ( int x = 0; x < arrayWithDots[y].length; x++ ) {
                s = s + ( arrayWithDots[y][x] == 0 ? "." : "#" );
                string.add( arrayWithDots[y][x] );
            }
            listWithDots.add( string );
            System.out.println( s );
        }

        List<List<Integer>> foldedArray = listWithDots;

        for ( int foldCounter = 0; foldCounter < folds.size(); foldCounter++ ) {
            boolean isX = folds.get( foldCounter ).contains( "x=" );
            int line = Integer.parseInt( folds.get( foldCounter ).split( "=" )[1] );
            foldedArray = foldArray( foldedArray, isX, line );
        }

        System.out.println();
        int sum = 0;
        for ( int y = 0; y < foldedArray.size(); y++ ) {
            String s = "";
            for ( int x = 0; x < foldedArray.get( y ).size(); x++ ) {
                sum = sum + foldedArray.get( y ).get( x );
                s = s + ( foldedArray.get( y ).get( x ) == 0 ? "." : "#" );
            }
            System.out.println( s );
        }
        System.out.println( sum );

    }


    public static List<List<Integer>> foldArray( List<List<Integer>> array, boolean isX, int line ) {
        List<List<Integer>> foldedArray = new ArrayList<>();

        if ( isX ) {

            foldedArray = initList( line, array.size() );

            for ( int y = 0; y < array.size();  y++ ) {
                for ( int x = 0; x < line; x++ ) {
                    foldedArray.get( y ).set( x, array.get( y ).get( x ) );
                }

            }
            for ( int y = 0; y < array.size(); y++ ) {
                for ( int x = line + 1; x < array.get( 0 ).size(); x++ ) {
                    int val = foldedArray.get( y ).get( line * 2 - x ) + array.get( y ).get( x );
                    foldedArray.get( y ).set( line * 2 - x, val >= 1 ? 1 : 0 );
                }
            }
        } else {

            foldedArray = initList( array.get( 0 ).size() , line );

            for ( int y = 0; y < line; y++ ) {
                for ( int x = 0; x < array.get( y ).size(); x++ ) {
                    foldedArray.get( y ).set( x, array.get( y ).get( x ) );
                }
            }
            for ( int y = line + 1; y < array.size(); y++ ) {
                for ( int x = 0; x < array.get( 0 ).size(); x++ ) {
                    int val = foldedArray.get( line * 2 - y ).get( x ) + array.get( y ).get( x );
                    foldedArray.get( line * 2 - y ).set( x, val >= 1 ? 1 : 0 );
                }
            }
        }
        return foldedArray;
    }

    public static List<List<Integer>> initList( int maxX, int maxY){
        List<List<Integer>> array = new ArrayList<>();
        for ( int y = 0; y < maxY; y++ ) {
            List<Integer> emptyString = new ArrayList<>();
            for ( int x = 0; x < maxX; x++ ) {
                emptyString.add( 0 );
            }
            array.add( emptyString );
        }
        return array;
    }

}
