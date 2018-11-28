package immortal.com.nmmimmortal;

import android.util.Log;

public class CheckPosition {

    public CheckPosition(){

    }

    public Coordinate check(int x, int y, Coordinate[] coords){
        Log.i("CheckPosition","-------------------------------------");
        Log.i("CheckPosition","Checking x: " + Integer.toString(x) + " y: " + Integer.toString(y));
        for(int i = 1; i<coords.length;i++){
            Log.i("CheckPosition","Coordinate " + Integer.toString(i)+ " x: " + Float.toString(coords[i].getX()) + " y: " + Float.toString(coords[i].getY()));
            if((x > coords[i].getX() && x < coords[i].getX()+175) && (y > coords[i].getY() && y < coords[i].getY() + 175)){
                return coords[i];
            } else if ((x> coords[i].getX() -175 && x < coords[i].getX()) && (y > coords[i].getY() - 175 && y < coords[i].getY())){
                return coords[i];
            } else if((x> coords[i].getX() && x < coords[i].getX() + 175 ) && (y> coords[i].getY() - 175 && y < coords[i].getY())){
                return coords[i];
            } else if((x > coords[i].getX() - 175 && x < coords[i].getX()) && (y - 175> coords[i].getY() && y < coords[i].getY() + 175)){
                return coords[i];
            }
        }
        return new Coordinate(-1,-1);
    }

    public int checkPos(int x, int y, Coordinate[] coords){
        for(int i = 1; i<coords.length;i++){
            Log.i("CheckPosition","Coordinate " + Integer.toString(i)+ " x: " + Float.toString(coords[i].getX()) + " y: " + Float.toString(coords[i].getY()));
            if((x > coords[i].getX() && x < coords[i].getX()+50) && (y > coords[i].getY() && y < coords[i].getY() + 50)){
                return i;
            } else if ((x> coords[i].getX() -50 && x < coords[i].getX()) && (y > coords[i].getY() - 50 && y < coords[i].getY())){
                return i;
            } else if((x> coords[i].getX() && x < coords[i].getX() + 50 ) && (y> coords[i].getY() - 50 && y < coords[i].getY())){
                return i;
            } else if((x > coords[i].getX() - 50 && x < coords[i].getX()) && (y - 50> coords[i].getY() && y < coords[i].getY() + 50)){
                return i;
            }
        }
        return 0;
    }
}
