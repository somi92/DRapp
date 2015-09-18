package rs.fon.drapp.loaders;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by milos on 9/18/15.
 */
public class AssetsManager {

    private static AssetsManager INSTANCE;

    private AssetsManager() {

    }

    public static AssetsManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AssetsManager();
        }
        return INSTANCE;
    }

    public Drawable getDrawableAsset(Context context, String fileName) {
        InputStream is = null;
        try {
            is = context.getAssets().open(fileName);
            Drawable drawable = Drawable.createFromStream(is, null);
            return drawable;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playSound(Context context, String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = context.getAssets().openFd(fileName);
            MediaPlayer player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(afd != null)
                    afd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
