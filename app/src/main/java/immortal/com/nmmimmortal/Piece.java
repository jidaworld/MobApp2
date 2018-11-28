package immortal.com.nmmimmortal;

import android.widget.ImageView;

import java.io.File;

public class Piece {

    private float x;
    private float y;
    private ImageView piece;
    private int position;

    public Piece(){

    }

    public ImageView getPiece() {
        return piece;
    }

    public void setPiece(ImageView piece) {
        this.piece = piece;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
