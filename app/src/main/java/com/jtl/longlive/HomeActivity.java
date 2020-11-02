package com.jtl.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jtl.longlive.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TianLong
 * @date 2020-11-2
 */
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private  List<LiveData> mLiveData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mRecyclerView = findViewById(R.id.rv_home_show);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mHomeAdapter = new HomeAdapter(this,getLiveList());
        mRecyclerView.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                LiveData liveData =((LiveData)adapter.getData());
                String url = liveData.url;
                String name = liveData.name;
                intent.putExtra("Url",url);
                intent.putExtra("Name",name);
                startActivity(intent);
                Log.d(TAG,liveData.toString());
            }
        });
    }

    private List getLiveList(){
        String listData = this.getString(R.string.list);
        String list = listData.replaceAll(",\n",",");
        ArrayList<LiveData> arrayList = new ArrayList<LiveData>(16);

        String [] result = list.split(",");
        for (int i=0;i<result.length;i++){
            String [] res = result[i].split("：");
            if (res.length==2){
                LiveData liveData = new LiveData(res[0],res[1]);
                arrayList.add(liveData);
            }
        }
        return arrayList;
    }
}