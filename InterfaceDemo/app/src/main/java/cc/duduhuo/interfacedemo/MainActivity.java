package cc.duduhuo.interfacedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cc.duduhuo.interfacedemo.callback.OnInfoFetchCallback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 获取信息
     * @param view
     */
    public void fetchInfo(View view) {
        InfoService service = new InfoService(new OnInfoFetchCallback() {
            @Override
            public void onSuccess(String info) {
                Log.i(TAG, info);
            }

            @Override
            public void failure() {
                Log.i(TAG, "获取信息失败");
            }
        });
        service.getInfo();
    }
}
