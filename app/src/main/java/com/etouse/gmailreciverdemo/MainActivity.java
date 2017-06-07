package com.etouse.gmailreciverdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements EmailAdapter.OnItemClickListener {

    @Bind(R.id.iv_query)
    ImageView ivQuery;
    @Bind(R.id.ll_query)
    LinearLayout llQuery;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_count)
    TextView tvCount;
    @Bind(R.id.iv_delete)
    ImageView ivDelete;
    @Bind(R.id.ll_delete)
    LinearLayout llDelete;
    @Bind(R.id.recycleview)
    RecyclerView recycleview;
    private List<EmailBean> mDatas = new ArrayList<>();
    private EmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }



    private void initView() {
        adapter = new EmailAdapter(mDatas, MainActivity.this,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setAdapter(adapter);
    }

    private void initData() {
        mDatas.add(new EmailBean(R.mipmap.star1, "掘金，Apple，Vivo商业账户系统通知", "高技术的技术分享社区，这里汇集了来自技术的学习与交流","10:01 AM"));
        mDatas.add(new EmailBean(R.mipmap.star2, "QQ音乐付费音乐包业务通知", "您的付费音乐包已过期","12:19 AM"));
        mDatas.add(new EmailBean(R.mipmap.star3, "环信", "智能硬件创业供应商选型经验指南","01:32 PM"));
        mDatas.add(new EmailBean(R.mipmap.star2, "交通银行信用卡中心", "超低价给幸运儿，天使额度快签约吧！","01:32 PM"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked() {
        int countChoosed = 0;
        for (int i = 0; i < mDatas.size(); i++) {
            if (mDatas.get(i).isChoosed()) {
                countChoosed++;
            }
        }

        if (countChoosed > 0) {
            llDelete.setVisibility(View.VISIBLE);
            llQuery.setVisibility(View.GONE);
            tvCount.setText(countChoosed + "");
        } else {
            llDelete.setVisibility(View.GONE);
            llQuery.setVisibility(View.VISIBLE);
        }
    }
}
