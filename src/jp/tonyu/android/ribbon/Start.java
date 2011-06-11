package jp.tonyu.android.ribbon;

import jp.tonyu.device.android.AndroidDevice;
import jp.tonyu.device.android.TonyuView;
import jp.tonyu.kernel.Boot;
import jp.tonyu.kernel.Global;
import jp.tonyu.samples.first.Object1;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;

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
		final Bitmap ball=BitmapFactory.decodeResource(getResources(), R.drawable.ballold,
      			options );

		final AndroidDevice dev=new AndroidDevice(this);
		//BitmapPatternParser a=(BitmapPatternParser) dev.getPatternParserFactory().newPatternParser(b);
		TonyuView t=(TonyuView) dev.getScreen();//new TonyuView(this,p);
		setContentView(t);
		t.getHolder().addCallback(new SurfaceHolder.Callback() {

			@Override
			public void surfaceChanged(SurfaceHolder surfaceholder, int i,
					int j, int k) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void surfaceCreated(SurfaceHolder surfaceholder) {
				Log.d("pp","Surfacecret");
				new Thread(new Runnable() {
					@Override
					public void run() {
						Boot b = new Boot(dev, new Global());
						try {
							b.getPatternSequencer().add(ball);
							b.appear(new Object1() .construct_PlainChar(50,50,4));
							b.appear(new Object1() .construct_PlainChar(150,30,8));
							b.doLoop();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();

			}

			@Override
			public void surfaceDestroyed(SurfaceHolder surfaceholder) {
				// TODO 自動生成されたメソッド・スタブ

			}

		});

    }
}