package cc.duduhuo.timelinerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cc.duduhuo.timelinerecyclerview.adapter.TraceListAdapter;
import cc.duduhuo.timelinerecyclerview.model.Trace;

/**
 * =======================================================
 * 版权：Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying - liruoer2008@yeah.net
 * 日期：2016/12/7 20:25
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public class TraceActivity extends AppCompatActivity {

    private RecyclerView rvTrace;
    private List<Trace> traceList = new ArrayList<>(10);
    private TraceListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);
        findView();
        initData();
    }

    private void findView() {
        rvTrace = (RecyclerView) findViewById(R.id.rvTrace);
    }

    private void initData() {
        // 模拟一些假的数据
        traceList.add(new Trace("2016-05-25 17:48:00", "[沈阳市] [沈阳和平五部]的派件已签收 感谢使用中通快递,期待再次为您服务!"));
        traceList.add(new Trace("2016-05-25 14:13:00", "[沈阳市] [沈阳和平五部]的东北大学代理点正在派件 电话:18040xxxxxx 请保持电话畅通、耐心等待"));
        traceList.add(new Trace("2016-05-25 13:01:04", "[沈阳市] 快件到达 [沈阳和平五部]"));
        traceList.add(new Trace("2016-05-25 12:19:47", "[沈阳市] 快件离开 [沈阳中转]已发往[沈阳和平五部]"));
        traceList.add(new Trace("2016-05-25 11:12:44", "[沈阳市] 快件到达 [沈阳中转]"));
        traceList.add(new Trace("2016-05-24 03:12:12", "[嘉兴市] 快件离开 [杭州中转部]已发往[沈阳中转]"));
        traceList.add(new Trace("2016-05-23 21:06:46", "[杭州市] 快件到达 [杭州汽运部]"));
        traceList.add(new Trace("2016-05-23 18:59:41", "[杭州市] 快件离开 [杭州乔司区]已发往[沈阳]"));
        traceList.add(new Trace("2016-05-23 18:35:32", "[杭州市] [杭州乔司区]的市场部已收件 电话:18358xxxxxx"));
        adapter = new TraceListAdapter(this, traceList);
        rvTrace.setLayoutManager(new LinearLayoutManager(this));
        rvTrace.setAdapter(adapter);
    }
}
