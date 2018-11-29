package immortal.com.nmmimmortal;

import android.util.Log;

public class CheckPosition {

    public CheckPosition(){

    }

    public Coordinate check(int x, int y, Coordinate[] coords){
        Log.i("CheckPosition","-------------------------------------");
        Log.i("CheckPosition","Check checking x: " + Integer.toString(x) + " y: " + Integer.toString(y));
        for(int i = 1; i<coords.length;i++){
            if((x > coords[i].getX()-100 && x < coords[i].getX()+100) && (y > coords[i].getY()-100 && y < coords[i].getY() + 100)){
                System.out.println(coords[i].getX() + " " + coords[i].getY());
                return coords[i];
            }
        }
        return new Coordinate(-1,-1);
    }

    public int checkPos(int x, int y, Coordinate[] coords){
        Log.i("CheckPosition","Checkpos checking x: " + Integer.toString(x) + " y: " + Integer.toString(y));
        for(int i = 1; i<coords.length;i++){
            Log.i("CheckPosition","Coordinate " + Integer.toString(i)+ " x: " + Float.toString(coords[i].getX()) + " y: " + Float.toString(coords[i].getY()));
            if((x > coords[i].getX()-100 && x < coords[i].getX()+100) && (y > coords[i].getY()-100 && y < coords[i].getY() + 100)){
                return i;
            }
        }
        return 0;
    }
}
