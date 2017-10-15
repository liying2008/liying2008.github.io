package cc.duduhuo.splashdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cc.duduhuo.splashdemo.task.SplashLoadDataTask;

public class SplashActivity extends AppCompatActivity implements SplashLoadDataTask.LoadDataCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 启动加载应用数据任务类
        SplashLoadDataTask task = new SplashLoadDataTask(this);
        task.execute();
    }

    /**
     * 跳转界面
     */
    private void jump() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 此处可以根据版本号进行一些判断，再跳转到相应的界面
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 500);   // 停留时间500ms
    }

    /**
     * 数据加载完成
     */
    @Override
    public void loaded() {
        jump();
    }

    /**
     * 数据加载出错
     */
    @Override
    public void loadError() {
        // 进行出错处理
        // ...

        jump();
    }

    @Override
    public void onBackPressed() {
        // Splash界面不允许使用back键
    }
}
