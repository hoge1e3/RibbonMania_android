package jp.tonyu.android.ribbon;

import jp.tonyu.device.android.AndroidDevice;
import jp.tonyu.device.android.TonyuView;
import jp.tonyu.kernel.Boot;
import jp.tonyu.kernel.Global;
import jp.tonyu.samples.first.Object1;
import jp.tonyu.samples.ribbon.RGlobal;
import jp.tonyu.samples.ribbon.page.Index;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;

public class Start extends Activity {
	Boot boot;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      	BitmapFactory.Options options = new BitmapFactory.Options();
      	options.inDither=false;
      	options.inScaled=false;
      	options.inPreferredConfig=Config.ARGB_8888;
		Bitmap ball=BitmapFactory.decodeResource(getResources(), R.drawable.ballold,
      			options );
		Bitmap ribbon=BitmapFactory.decodeResource(getResources(), R.drawable.ribbon,
      			options );


		AndroidDevice dev=new AndroidDevice(this);
		dev.getResourceList().add("ball", ball);
		dev.getResourceList().add("ribbon", ribbon);
		 boot = new Boot(dev, new RGlobal());
		try {
			//b.getPatternSequencer().add(b.getDevice().getResourceList().getImageResource("ball"));
			//b.getPatternSequencer().add(b.getDevice().getResourceList().getImageResource("ribbon"));
			new Index().load(boot);
		} catch(Exception e) {
			Log.e("pp","Er2:",e);
		}

		//BitmapPatternParser a=(BitmapPatternParser) dev.getPatternParserFactory().newPatternParser(b);
		TonyuView t=(TonyuView) dev.getScreen();//new TonyuView(this,p);
		setContentView(t);
		t.getHolder().addCallback(new SurfaceHolder.Callback() {
			boolean created=false;
			@Override
			public void surfaceChanged(SurfaceHolder surfaceholder, int i,
					int j, int k) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void surfaceCreated(SurfaceHolder surfaceholder) {
				Log.d("pp","Surfacecret");
				if (created) return;
				created=true;
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							//b.appear(new Object1() .construct_PlainChar(50,50,4));
							//b.appear(new Object1() .construct_PlainChar(80,30,8));

							boot.doLoop();
						} catch (Exception e) {
							Log.e("pp","Exp:",e);
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
    @Override
    protected void onPause() {
    	if (boot!=null) boot.pause(true);
    	super.onPause();
    }
    @Override
    protected void onResume() {
    	if (boot!=null) boot.pause(false);
    	super.onResume();
    }
}