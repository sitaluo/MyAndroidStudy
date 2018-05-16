package example.kevinwu.com.myandroidstudy;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import example.kevinwu.com.common.ToastUtils;

public class LiveListActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView liveListRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        liveListRecycleView = findViewById(R.id.live_list_recyclerView);

        swipeRefreshLayout.setOnRefreshListener(()->{
            ToastUtils.show(this,"onrefresh");
            swipeRefreshLayout.setRefreshing(false);
        });


    }
}
