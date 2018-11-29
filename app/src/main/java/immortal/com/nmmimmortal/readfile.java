package immortal.com.nmmimmortal;

import android.app.Activity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class readfile {

    private Activity activity;

    public readfile(Activity activity){
        this.activity = activity;
    }

    public Game read(){
        FileInputStream in = null;
        ObjectInputStream o = null;
        Game game = null;

        try {
            in = activity.openFileInput("savegame.txt");
            o = new ObjectInputStream(in);
            game = (Game)o.readObject();
            return game;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if(in != null){
                    in.close();
                }
                if(o != null){
                    o.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
