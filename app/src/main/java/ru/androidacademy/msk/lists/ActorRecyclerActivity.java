package ru.androidacademy.msk.lists;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.androidacademy.msk.lists.data.DataUtils;

public class ActorRecyclerActivity extends AppCompatActivity {

  private final ActorRecyclerAdapter.OnItemClickListener clickListener = actor -> {
    String clickMessage = DataUtils.getActorMessage(this, actor);
    Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_actor_recycler);

    ActionBar ab = getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
    }

    RecyclerView list = findViewById(R.id.recycler);
    list.setAdapter(new ActorRecyclerAdapter(this, DataUtils.generateActors(), clickListener));
    list.setLayoutManager(new LinearLayoutManager(this));
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
