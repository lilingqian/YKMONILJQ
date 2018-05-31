package com.example.lenovo.yk_moni_ljq.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.yk_moni_ljq.R;
import com.example.lenovo.yk_moni_ljq.bean.BannerBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/3/6.
 */

public class GAdapter  extends RecyclerView.Adapter<GAdapter.MyViewHolder>{


    List<BannerBean.MiaoshaBean.ListBeanX> ter;
    Context context;

    public GAdapter(List<BannerBean.MiaoshaBean.ListBeanX> ter, Context context) {
        this.context = context;
        this.ter = ter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_lianglie, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String[] split = ter.get(position).getImages().split("\\|");
        holder.simple.setImageURI(Uri.parse(split[0]));
        holder.price1.setText(ter.get(position).getPrice() + "");
        holder.youhui1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线（删除线）
        holder.youhui1.setText(ter.get(position).getBargainPrice() + "");
        holder.title.setText(ter.get(position).getTitle() + "");
    }

    @Override
    public int getItemCount() {
        return ter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.price1)
        TextView price1;
        @BindView(R.id.youhui1)
        TextView youhui1;
        @BindView(R.id.title)
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
