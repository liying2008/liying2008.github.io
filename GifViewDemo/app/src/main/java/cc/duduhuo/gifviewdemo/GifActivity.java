package cc.duduhuo.gifviewdemo;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import cc.duduhuo.gifviewdemo.view.GifView;

public class GifActivity extends AppCompatActivity {
    private static final String TAG = "GifActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        GifView gifView = (GifView) findViewById(R.id.gifView);
        Intent intent = getIntent();
        int gif = intent.getIntExtra("gif", R.drawable.gif1);
        gifView.setGifResource(gif);    // 设置显示的Gif图片

        int width = gifView.getGifWidth();
        int height = gifView.getGifHeight();
        Log.i(TAG, "GifWidth = " + width + ", GifHeight = " + height);
        int screenWidth = getScreenSize().width();
        int screenHeight = getScreenSize().height();
        Log.i(TAG, "ScreenWidth = " + screenWidth + ", ScreenHeight = " + screenHeight);
        if (width > 0 && height > 0) {
            float wScale = (float) screenWidth / width;
            float hScale = (float) screenHeight / height;
            if (wScale < 1 || hScale < 1) {
                // 如果图片的宽或高大于屏幕的宽或高，则图片会自动缩小至全屏
            } else if (wScale <= hScale) {
                // 宽度全屏
                gifView.setScaleX(wScale);
                gifView.setScaleY(wScale);
            } else {
                // 高度全屏
                gifView.setScaleX(hScale);
                gifView.setScaleY(hScale);
            }
        }
    }

    /**
     * 得到屏幕的尺寸
     *
     * @return 包含屏幕尺寸的Rect对象
     */
    private Rect getScreenSize() {
        Rect localRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        return localRect;
    }

}
