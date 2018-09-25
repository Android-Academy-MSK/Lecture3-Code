package ru.androidacademy.msk.lists;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.androidacademy.msk.lists.data.Actor;
import ru.androidacademy.msk.lists.data.DataUtils;

public class ActorListActivity extends AppCompatActivity {

  private ActorListAdapter adapter;

  private final AdapterView.OnItemClickListener clickListener = (adapterView, view, position, id) -> {
    Actor actor = adapter.getItem(position);
    String clickMessage = DataUtils.getActorMessage(this, actor);

    Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_actor_list);

    ListView list = findViewById(R.id.list);
    adapter = new ActorListAdapter(this, DataUtils.generateActors());
    list.setAdapter(adapter);
    list.setOnItemClickListener(clickListener);
  }

  @Override
  public boolean onCreateOptionsMenu(@NonNull Menu menu) {
    getMenuInflater().inflate(R.menu.menu_list, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_switch:
        startActivity(new Intent(this, ActorRecyclerActivity.class));
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
