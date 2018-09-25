package ru.androidacademy.msk.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import ru.androidacademy.msk.lists.data.Actor;

public class ActorRecyclerAdapter extends RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder> {
  @NonNull
  private final List<Actor> actors;
  @NonNull
  private final LayoutInflater inflater;
  @Nullable
  private final OnItemClickListener clickListener;
  @NonNull
  private final RequestManager imageLoader;

  public ActorRecyclerAdapter(@NonNull Context context, @NonNull List<Actor> actors,
      @Nullable OnItemClickListener clickListener) {
    this.actors = actors;
    this.inflater = LayoutInflater.from(context);
    this.clickListener = clickListener;

    RequestOptions imageOption = new RequestOptions()
        .placeholder(R.drawable.avatar_placeholder)
        .fallback(R.drawable.avatar_placeholder)
        .centerCrop();
    this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(inflater.inflate(R.layout.item_actor, parent, false), clickListener);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bind(actors.get(position));
  }

  @Override
  public int getItemCount() {
    return actors.size();
  }

  public interface OnItemClickListener {
    void onItemClick(Actor actor);
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private final ImageView avatarView;
    private final TextView nameView;
    private final ImageView oscarView;

    ViewHolder(@NonNull View itemView, @Nullable OnItemClickListener listener) {
      super(itemView);
      itemView.setOnClickListener(view -> {
        int position = getAdapterPosition();
        if (listener != null && position != RecyclerView.NO_POSITION) {
          listener.onItemClick(actors.get(position));
        }
      });
      avatarView = itemView.findViewById(R.id.avatar);
      nameView = itemView.findViewById(R.id.name);
      oscarView = itemView.findViewById(R.id.oscar);
    }

    void bind(Actor actor) {
      imageLoader.load(actor.getAvatarUrl()).into(avatarView);
      nameView.setText(actor.getName());
      oscarView.setVisibility(actor.hasOscar() ? View.VISIBLE : View.GONE);
    }
  }
}
