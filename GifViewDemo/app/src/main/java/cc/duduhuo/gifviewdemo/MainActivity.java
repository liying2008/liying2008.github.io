package cc.duduhuo.gifviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 高度较小
     *
     * @param view
     */
    public void showGif1(View view) {
        show(R.drawable.gif1);
    }

    /**
     * 宽度较小
     *
     * @param view
     */
    public void showGif2(View view) {
        show(R.drawable.gif2);
    }

    /**
     * 宽高大于屏幕
     *
     * @param view
     */
    public void showGif3(View view) {
        show(R.drawable.gif3);
    }

    /**
     * 高度大于屏幕
     *
     * @param view
     */
    public void showGif4(View view) {
        show(R.drawable.gif4);
    }

    /**
     * 跳转到GifActivity显示Gif图片
     *
     * @param resource
     */
    private void show(@DrawableRes int resource) {
        Intent intent = new Intent(this, GifActivity.class);
        intent.putExtra("gif", resource);
        startActivity(intent);
    }
}
