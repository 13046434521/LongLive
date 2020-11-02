package com.jtl.longlive.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jtl.longlive.HomeActivity;
import com.jtl.longlive.LiveData;
import com.jtl.longlive.MainActivity;
import com.jtl.longlive.R;

import java.util.List;

/**
 * @author：TianLong
 * @date：2020/10/30 19:15
 */
public class HomeAdapter extends BaseQuickAdapter<LiveData,BaseViewHolder>{
    private Activity mContext;
    public HomeAdapter(Activity context ,@Nullable List<LiveData> data) {
        super(R.layout.layout_home_item, data);
        mContext =context;
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveData item) {
        ((TextView)helper.getView(R.id.layout_home_item_txt)).setText(item.name);
        Log.d("HomeAdapter",item.toString());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                String url = item.url;
                String name = item.name;
                intent.putExtra("Url",url);
                intent.putExtra("Name",name);
                (mContext).startActivity(intent);
            }
        });
    }
}
