package com.snake.mindvally.ui.list;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.snake.mindvally.R;
import com.snake.mindvally.data.model.pojo.Data;
import com.snake.mindvally.util.DownloadImageTask;
import com.snake.mindvally.util.ThumbnailLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {

    private RepoSelectedListener repoSelectedListener;
    private final List<Data> data = new ArrayList<>();
    private static ThumbnailLoader tnloader ;

    RepoListAdapter(Context context,ListViewModel viewModel, LifecycleOwner lifecycleOwner, RepoSelectedListener repoSelectedListener) {
        this.repoSelectedListener = repoSelectedListener;
        viewModel.getRepos().observe(lifecycleOwner, repos -> {
            data.clear();
            if (repos != null) {
                data.addAll(repos);
                notifyDataSetChanged();
            }
        });
        tnloader= new ThumbnailLoader(context);
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new RepoViewHolder(view, repoSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    static final class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userName)
        TextView userName;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.profilePic)
        ImageView profilePic;

        private Data data;

        RepoViewHolder(View itemView, RepoSelectedListener repoSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (data != null) {
                    repoSelectedListener.onRepoSelected(data.getUser());
                }
            });
        }

        void bind(Data data) {
            this.data = data;
            userName.setText(data.getUser().getUsername());
            name.setText(data.getUser().getName());
            new DownloadImageTask(image).execute(data.getUrls().getRegular());
            new DownloadImageTask(profilePic).execute(data.getUser().getProfileImage().getMedium());
//            tnloader.loadBitmap(data.getUrls().getRegular(),image);
//            tnloader.loadBitmap(data.getUser().getProfileImage().getMedium(),profilePic);
        }
    }

}
