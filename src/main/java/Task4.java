import java.util.List;

public class Task4 {

    public static void main( String[] args ) {
        List<String> directions = Utils.readFromFile( "directions.txt" );

        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        for( String direction: directions){
            int shift = Integer.parseInt( direction.split( " " )[1]);
            if(direction.contains("down")){
                aim = aim + shift;
            }else if(direction.contains("up")){
                aim = aim - shift;
            }else if(direction.contains("forward")){
                horizontal = horizontal + shift;
                depth = depth + aim*shift;
            }
        }


        System.out.println( depth + " * "+ horizontal + " = " + depth * horizontal);
    }

}
