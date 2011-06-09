package jp.tonyu.device.android;

import java.io.IOException;

import jp.tonyu.kernel.device.Device;
import jp.tonyu.kernel.resource.Resource;
import jp.tonyu.kernel.screen.Screen;
import jp.tonyu.kernel.screen.pattern.PatternParser;
import jp.tonyu.kernel.screen.pattern.PatternParserFactory;

public class AndroidDevice implements Device {

	@Override
	public PatternParserFactory getPatternParserFactory() {

		return new PatternParserFactory() {
			@Override
			public PatternParser newPatternParser(Object r)
					throws IOException {
				return new AndroidPatternParser(r);
			}
		};
	}

	@Override
	public Screen getScreen() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
