package immortal.com.nmmimmortal;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.View.OnTouchListener;


public class MainActivity extends AppCompatActivity{

    private ViewGroup mainLayout;
    private float xDelta;
    private float yDelta;
    private float saveX;
    private float saveY;
    public Coordinate[] boardGame;
    private CheckPosition cp = new CheckPosition();
    private Game game;
    private int oldPos = 0;
    private boolean canKill = false;
    private BoardView bw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        mainLayout = (ConstraintLayout) findViewById(R.id.main);
        mainLayout.post(new Runnable() {
            @Override
            public void run() {
        createGame();

            }
        });
    }

    private OnTouchListener onTouchListener(){
        return new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent event){
                float x = event.getRawX();
                float y = event.getRawY();
                int action = event.getAction();
                int newPos = 0;
                String color = view.getContentDescription().toString();
                int colorInt = -1;

                if(!canKill) {
                    switch (action & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                            oldPos = cp.checkPos(Math.round(x), Math.round(y), boardGame);
                            ConstraintLayout.LayoutParams lParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                            xDelta = x - lParams.leftMargin;
                            yDelta = y - lParams.topMargin;
                            saveX = x;
                            saveY = y;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                            layoutParams.leftMargin = Math.round(x - xDelta);
                            layoutParams.topMargin = Math.round(y - yDelta);
                            layoutParams.rightMargin = 0;
                            layoutParams.bottomMargin = 0;
                            view.setLayoutParams(layoutParams);
                            break;

                        case MotionEvent.ACTION_UP:
                            ConstraintLayout.LayoutParams layParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                            Coordinate newCoord = cp.check(Math.round(x), Math.round(y), boardGame);
                            newPos = cp.checkPos(Math.round(x), Math.round(y), boardGame);
                            Log.i("GameLogic", "Started at: " + "(" + Float.toString(saveX) + "," + Float.toString(saveY) + ")");
                            Log.i("GameLogic", "Dropped at: " + "(" + Float.toString(x) + "," + Float.toString(y) + ")");
                            Log.i("GameLogic", "New Pos : " + newPos + " and old pos: " + oldPos);
                            if (newCoord.getX() == -1 && newCoord.getY() == -1) {
                                Log.i("GameLogic", "Failed");
                                layParams.leftMargin = Math.round(saveX - xDelta);
                                layParams.topMargin = Math.round(saveY - yDelta);
                                layParams.rightMargin = 0;
                                layParams.bottomMargin = 0;
                                view.setLayoutParams(layParams);
                            } else {
                                if (color.equals("RED_MARKER")) {
                                    colorInt = 2;
                                } else {
                                    colorInt = 1;
                                }
                                if (game.legalMove(newPos, oldPos, colorInt)) {
                                    Log.i("Motion", "Found spot");
                                    layParams.leftMargin = Math.round(newCoord.getX() - xDelta);
                                    layParams.topMargin = Math.round(newCoord.getY() - yDelta);
                                    layParams.rightMargin = 0;
                                    layParams.bottomMargin = 0;
                                    view.setLayoutParams(layParams);
                                    if (game.remove(newPos)) {
                                        Log.i("GameLogic", "Shoot to kill!");
                                        canKill = true;
                                    }
                                } else {
                                    layParams.leftMargin = Math.round(saveX - xDelta);
                                    layParams.topMargin = Math.round(saveY - yDelta);
                                    layParams.rightMargin = 0;
                                    layParams.bottomMargin = 0;
                                    view.setLayoutParams(layParams);
                                }

                            }
                            break;
                    }
                } else {
                    switch(action & MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            int deletePos = cp.checkPos(Math.round(x),Math.round(y),boardGame);
                            int selectedColor = game.board(deletePos);
                            if(selectedColor != colorInt){
                                if(game.remove(deletePos, selectedColor)) {
                                    canKill = false;
                                    view.setVisibility(view.GONE);
                                    Log.i("GameLogic","Deleted piece");
                                    if(game.win(colorInt)){
                                        Log.i("GameLogic","Winner: " + Integer.toString(colorInt));
                                    }
                                }
                            }
                    }
                }

                mainLayout.invalidate();
                return true;
            }
        };
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    private void createGame(){

        bw = new BoardView(this);

        ImageView board = (ImageView) findViewById(R.id.board);
        Log.i("Motion","Board dimension: " + Integer.toString(board.getWidth()) + " and: " + Integer.toString(board.getHeight()));
        float height = (float) board.getHeight();
        float width = (float) board.getWidth();
        Log.i("Mathtest", "" + (2*width)/6);

        boardGame = new Coordinate[25];
        boardGame[1] = new Coordinate((2*width)/6,(2*height)/6);
        boardGame[2] = new Coordinate((1*width)/6,(1*height)/6);
        boardGame[3] = new Coordinate(30,30);
        boardGame[4] = new Coordinate(3*width/6,2*height/6);
        boardGame[5] = new Coordinate(3*width/6,height/6);
        boardGame[6] = new Coordinate(3*width/6,30);
        boardGame[7] = new Coordinate(4*width/6,(2*height/6));
        boardGame[8] = new Coordinate(5*width/6,height/6);
        boardGame[9] = new Coordinate(6*width/6,30);
        boardGame[10] = new Coordinate(4*width/6,3*height/6);
        boardGame[11] = new Coordinate(5*width/6,3*height/6);
        boardGame[12] = new Coordinate(6*width/6,3*height/6);
        boardGame[13] = new Coordinate(4*width/6,4*height/6);
        boardGame[14] = new Coordinate(4*width/6,4*height/6);
        boardGame[15] = new Coordinate(6*width/6,6*height/6);
        boardGame[16] = new Coordinate(3*width/6,4*height/6);
        boardGame[17] = new Coordinate(3*width/6,5*height/6);
        boardGame[18] = new Coordinate(3*width/6,6*height/6);
        boardGame[19] = new Coordinate(2*width/6,4*height/6);
        boardGame[20] = new Coordinate(1*width/6,5*height/6);
        boardGame[21] = new Coordinate(30, 6*height/6);
        boardGame[22] = new Coordinate(2*width/6,3*height/6);
        boardGame[23] = new Coordinate(1*width/6,3*height/6);
        boardGame[24] = new Coordinate(30,3*height/6);

        for(int i = 0; i<9; i++){
            bw.getBlack()[i].setOnTouchListener(onTouchListener());
            bw.getRed()[i].setOnTouchListener(onTouchListener());
        }

        //Log.i("Motion","Board dimension: " + Integer.toString(board.getDrawable().getIntrinsicWidth()) + " and: " + Integer.toString(board.getDrawable().getIntrinsicHeight()));
    }



}
