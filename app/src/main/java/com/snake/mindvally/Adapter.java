package com.snake.mindvally;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.snake.mindvally.data.model.pojo.Data;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Data> dataList = new ArrayList<>();

    public Adapter(Context mContext, List<Data> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        ImageView profileImage;
        TextView userName;
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            profileImage=itemView.findViewById(R.id.profilePic);
            userName=itemView.findViewById(R.id.userName);
            name=itemView.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Data data=dataList.get(position);
        RequestBuilder<Drawable> imageThumbnail = Glide
                .with(mContext)
                .load(data.getUrls().getThumb());

        Glide.with(mContext)
                .load(data.getUrls().getRegular())
                .thumbnail(imageThumbnail)
                .into(holder.imageView);

        RequestBuilder<Drawable> proileImageThumbnail = Glide
                .with(mContext)
                .load(data.getUser().getProfileImage().getSmall());

        Glide.with(mContext)
                .load(data.getUser().getProfileImage().getMedium())
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(proileImageThumbnail)
                .into(holder.profileImage);
        holder.userName.setText(data.getUser().getUsername());
        holder.name.setText(data.getUser().getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
