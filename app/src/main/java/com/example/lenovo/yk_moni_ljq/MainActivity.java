package com.example.lenovo.yk_moni_ljq;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.yk_moni_ljq.Persenter.BannerPersenter;
import com.example.lenovo.yk_moni_ljq.adapter.BAdapter;
import com.example.lenovo.yk_moni_ljq.adapter.GAdapter;
import com.example.lenovo.yk_moni_ljq.bean.BannerBean;
import com.example.lenovo.yk_moni_ljq.view.BannerView;
import com.example.lenovo.yk_moni_ljq.view.CustomView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BannerView {

    BannerPersenter persenter = new BannerPersenter(this);
    private CustomView banner;
    List<String> list = new ArrayList<>();
    List<String> listurl = new ArrayList<>();
    List<BannerBean.MiaoshaBean.ListBeanX> ter = new ArrayList<BannerBean.MiaoshaBean.ListBeanX>();
    private TextView shi;
    private TextView fen;
    private TextView miao;
    private RecyclerView recycler_02;
    private RecyclerView recycler_01;
    static long mHour = 02;
    static long mMin = 15;
    boolean isRun = true;
    static long mSecond = 36;
    Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                //调用 倒计时计算的方法
                computeTime();
                if (mHour < 10) {
                    shi.setText("0" + mHour + "");
                } else {
                    shi.setText(mHour + "");
                }
                if (mMin < 10) {
                    fen.setText("0" + mMin + "");
                } else {
                    fen.setText(mMin + "");
                }
                if (mSecond < 10) {
                    miao.setText("0" + mSecond + "");
                } else {
                    miao.setText(mSecond + "");
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persenter.getData();
        banner = (CustomView) findViewById(R.id.mybanner);
        shi = findViewById(R.id.tv_hour);
        fen = findViewById(R.id.tv_minute);
        miao = findViewById(R.id.tv_second);
        recycler_01 = (RecyclerView) findViewById(R.id.recycler_01);
        recycler_02 = (RecyclerView) findViewById(R.id.recycler_02);
        startRun();

    }

    @Override
    public void success(BannerBean bean) {
        Toast.makeText(MainActivity.this, bean.getData().get(0).getTitle() + "", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i).getIcon());
//            listurl.add(bean.getData().get(i).getUrl());
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                banner.setData(list/*, listurl*/);
            }
        });

        //recyclerview横滑
        for (int i = 0; i < bean.getMiaosha().getList().size(); i++) {
            ter.add(bean.getMiaosha().getList().get(i));

        }
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recycler_01.setLayoutManager(manager);
        BAdapter badapter = new BAdapter(ter, MainActivity.this);
        recycler_01.setAdapter(badapter);
        //recyclerview双列
        GridLayoutManager manager1 = new GridLayoutManager(MainActivity.this, 2);
        recycler_02.setLayoutManager(manager1);
        GAdapter gAdapter = new GAdapter(ter, this);
        recycler_02.setAdapter(gAdapter);


    }

    @Override
    public void failuer(String e) {
        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun) {
                    try {
                        //睡眠一秒发送消息handler
                        Thread.sleep(1000);
                        Message message = Message.obtain();
                        message.what = 1;
                        //发送消息
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
//调用 倒计时计算的方法

    /**
     * 倒计时计算
     */
    private static void computeTime() {
        //首先把秒减1
        mSecond--;
        if (mSecond < 0) {//如果秒已经减到了0
            mMin--;//分钟就减1
            mSecond = 59;//秒变成 59
            if (mMin < 0) {//如果分钟小于0
                mMin = 59;//分钟变成59
                mHour--;//小时减1
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.banner();
    }
}
