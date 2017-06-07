package com.etouse.gmailreciverdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
    private final OnItemClickListener onItemClickListener;
    private List<EmailBean> mShowDatas;
    private Context context;

    public EmailAdapter(List<EmailBean> mShowDatas, Context context,OnItemClickListener onItemClickListener) {
        this.mShowDatas = mShowDatas;
        this.context = context;
        this.onItemClickListener =onItemClickListener;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_list_email, null);
        EmailViewHolder holder = new EmailViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final EmailViewHolder holder, final int position) {
        holder.ivIcon.setImageResource(mShowDatas.get(position).getIcon());
        holder.tvTitle.setText(mShowDatas.get(position).getTitle());
        holder.tvTimer.setText(mShowDatas.get(position).getTimer());
        holder.tvDescription.setText(mShowDatas.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowDatas.get(position).setChoosed(!mShowDatas.get(position).isChoosed());
                if (mShowDatas.get(position).isChoosed()) {
                    holder.ivIcon.setImageResource(R.mipmap.icon_selected);
                    holder.llContent.setBackgroundColor(Color.parseColor("#33757575"));
//                    applyRotation(holder.ivIcon,-90,0);
                } else {
                    holder.ivIcon.setImageResource(mShowDatas.get(position).getIcon());
                    holder.llContent.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                onItemClickListener.onItemClicked();
            }
        });
    }

    private void applyRotation(View view ,float start, float end) {
        // 计算中心点
        final float centerX = view.getWidth() / 2 ;
        final float centerY = view.getHeight() /2 ;

        final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end,
                centerX, centerY, 310.0f, true);
        rotation.setDuration(200);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());

        view.startAnimation(rotation);
    }

    @Override
    public int getItemCount() {
        return mShowDatas.size();
    }

    class EmailViewHolder extends RecyclerView.ViewHolder{

        private final ImageView ivIcon;
        private final TextView tvTitle;
        private final TextView tvTimer;
        private final TextView tvDescription;
        private final View llContent;

        public EmailViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvTimer = (TextView) itemView.findViewById(R.id.tv_timer);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            llContent = itemView.findViewById(R.id.ll_content);
        }
    }

    public interface OnItemClickListener{
        void onItemClicked();
    }
}
