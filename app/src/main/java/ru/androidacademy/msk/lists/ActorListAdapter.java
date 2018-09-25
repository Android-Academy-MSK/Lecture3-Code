package ru.androidacademy.msk.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import ru.androidacademy.msk.lists.data.Actor;

public class ActorListAdapter extends BaseAdapter {
  @NonNull
  private final List<Actor> actors;
  @NonNull
  private final LayoutInflater inflater;
  @NonNull
  private final RequestManager imageLoader;

  public ActorListAdapter(@NonNull Context context, @NonNull List<Actor> actors) {
    this.actors = actors;
    this.inflater = LayoutInflater.from(context);

    RequestOptions imageOption = new RequestOptions()
        .placeholder(R.drawable.avatar_placeholder)
        .fallback(R.drawable.avatar_placeholder)
        .centerCrop();
    this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);
  }

  @Override
  public int getCount() {
    return actors.size();
  }

  @Override
  public Actor getItem(int position) {
    return actors.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      holder = onCreateViewHolder(parent);
      convertView = holder.itemView;
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    onBindViewHolder(holder, position);

    return convertView;
  }

  private ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
    return new ViewHolder(inflater.inflate(R.layout.item_actor, parent, false));
  }

  private void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Actor actor = actors.get(position);

    imageLoader.load(actor.getAvatarUrl()).into(holder.avatarView);
    holder.nameView.setText(actor.getName());
    holder.oscarView.setVisibility(actor.hasOscar() ? View.VISIBLE : View.GONE);
  }

  static class ViewHolder {
    final View itemView;

    final ImageView avatarView;
    final TextView nameView;
    final ImageView oscarView;

    ViewHolder(@NonNull View itemView) {
      this.itemView = itemView;
      this.avatarView = itemView.findViewById(R.id.avatar);
      this.nameView = itemView.findViewById(R.id.name);
      this.oscarView = itemView.findViewById(R.id.oscar);
    }
  }
}
