package cc.duduhuo.fragmentattachdemo.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cc.duduhuo.fragmentattachdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {
    private TextView tvMsg;
    private Button btnStartTask, btnRecreate;
    private static final String TAG = "FirstFragment";

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvMsg = (TextView) view.findViewById(R.id.tvMsg);
        btnStartTask = (Button) view.findViewById(R.id.btnStartTask);
        btnRecreate = (Button) view.findViewById(R.id.btnRecreate);
        btnStartTask.setOnClickListener(this);
        btnRecreate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartTask:
                // 模拟一个耗时任务
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        Log.d(TAG, "getActivity = " + getActivity());
                        if (isAdded()) {
                            tvMsg.setText(getResources().getString(R.string.app_name));
                        }
                    }
                }.execute();
                break;
            case R.id.btnRecreate:
                // 重新创建MainActivity
                getActivity().recreate();
                break;
        }
    }
}
