package immortal.com.nmmimmortal;

public class Coordinate {
    private float x;
    private float y;
    private int position;

    public Coordinate(float x, float y) {
        this.x =x;
        this.y =y;
    }

    public float getX() {
        return x;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int i){
        this.position = i;
    }


    public float getY() {
        return y;
    }

}
