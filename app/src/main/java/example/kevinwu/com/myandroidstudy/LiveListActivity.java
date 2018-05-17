package example.kevinwu.com.myandroidstudy;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.kevinwu.com.common.ToastUtils;
import example.kevinwu.com.myandroidstudy.adapter.LiveRoomListAdapter;

public class LiveListActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView liveListRecycleView;
    private ArrayList<String> dataList = new ArrayList<>();
    LiveRoomListAdapter liveRoomListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        liveListRecycleView = findViewById(R.id.live_list_recyclerView);
        liveRoomListAdapter = new LiveRoomListAdapter(this,dataList);
        liveListRecycleView.setAdapter(liveRoomListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        liveListRecycleView.setLayoutManager(linearLayoutManager);

        swipeRefreshLayout.setOnRefreshListener(()->{
            ToastUtils.show(this,"onrefresh");
            //swipeRefreshLayout.setRefreshing(false);
            dataList.clear();
            loadMoreData();
        });
        loadMoreData();
        liveListRecycleView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch(newState)
                {
                    case 0:
                        System.out.println("recyclerview已经停止滚动");
                        break;
                    case 1:
                        System.out.println("recyclerview正在被拖拽");
                        break;
                    case 2:
                        System.out.println("recyclerview正在依靠惯性滚动");
                        break;
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItemPosition=linearLayoutManager.findFirstVisibleItemPosition();//可见范围内的第一项的位置
                int lastVisibleItemPosition=linearLayoutManager.findLastVisibleItemPosition();//可见范围内的最后一项的位置
                int itemCount=linearLayoutManager.getItemCount();//recyclerview中的item的所有的数目
                if(lastVisibleItemPosition  == liveRoomListAdapter.getItemCount()-1){
                    System.out.println("需要加载更多了");
                }
            }
        });

    }

    public void loadMoreData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int size = dataList.size();
                for (int i=0;i<10;i++){
                    dataList.add("item"+(size+i+1)+"_"+(int)(Math.random()*100));
                }
                updateView();
            }
        }, 1500);

    }

    private void updateView(){
        liveRoomListAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
       // adapter.
    }

}
