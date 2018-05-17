package example.kevinwu.com.myandroidstudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.kevinwu.com.myandroidstudy.R;

/**
 * Created by kevinwu on 2018/5/17.
 */

public class LiveRoomListAdapter extends RecyclerView.Adapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> dataList;

    public LiveRoomListAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.live_room_list_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder item = (ItemViewHolder)holder;
        System.out.println("viewholder positopn"+ position);
        String data = dataList.get(position);
        item.textView.setText(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size() == 0 ? 0 : dataList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.liveTitle);
        }
    }

}
