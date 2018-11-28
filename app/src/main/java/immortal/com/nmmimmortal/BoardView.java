package immortal.com.nmmimmortal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class BoardView extends View {

    private ImageView[] red = new ImageView[9];
    private ImageView[] black = new ImageView[9];

    public BoardView(Context context) {
        super(context);

        red[0] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red1);
        red[1] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red2);
        red[2] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red3);
        red[3] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red4);
        red[4] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red5);
        red[5] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red6);
        red[6] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red7);
        red[7] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red8);
        red[8] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.red9);

        black[0] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black1);
        black[1] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black2);
        black[2] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black3);
        black[3] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black4);
        black[4] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black5);
        black[5] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black6);
        black[6] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black7);
        black[7] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black8);
        black[8] = (ImageView) ((Activity)context).getWindow().getDecorView().findViewById(R.id.black9);

    }

    public ImageView[] getRed() {
        return red;
    }

    public ImageView[] getBlack() {
        return black;
    }
}
