package immortal.com.nmmimmortal;

import android.app.Activity;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class writefile {

    private String filename = "savegame.txt";
    private Activity activity;

    public writefile(Activity activity){
        this.activity = activity;

    }

    public void write(Game game){
        FileOutputStream out = null;
        ObjectOutputStream o = null;

        try {
            out = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            o = new ObjectOutputStream(out);
            o.writeObject(game);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(o != null){
                    o.close();
                }
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
