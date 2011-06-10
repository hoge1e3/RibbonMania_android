package jp.tonyu.android.ribbon;

import java.util.List;

import jp.tonyu.device.android.AndroidPatternParser;
import jp.tonyu.device.android.TonyuView;
import jp.tonyu.kernel.screen.pattern.CharPattern;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class Start extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      	BitmapFactory.Options options = new BitmapFactory.Options();
      	options.inDither=false;
      	options.inScaled=false;
      	options.inPreferredConfig=Config.ARGB_8888;
		Bitmap b=BitmapFactory.decodeResource(getResources(), R.drawable.ballold,
      			options );

      	AndroidPatternParser a = new AndroidPatternParser(b);
      	List<CharPattern> p = a.parse();
      	TonyuView t=new TonyuView(this,p);

      	setContentView(t);
    }
}