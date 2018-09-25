package ru.androidacademy.msk.lists.data;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import ru.androidacademy.msk.lists.R;

public class DataUtils {

  public static List<Actor> generateActors() {
    List<Actor> actors = new ArrayList<>();
    actors.add(new Actor("Alicia Vikander", "https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg", true));
    actors.add(new Actor("Amanda Seyfried", "https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg", false));
    actors.add(new Actor("Anne Hathaway", "https://image.ibb.co/euy6Py/Anne_Hathaway.jpg", true));
    actors.add(new Actor("Emma Stone", "https://image.ibb.co/dJY6Py/Emma_Stone.jpg", true));
    actors.add(new Actor("Keira Knightley", "https://image.ibb.co/cxX0jy/Keira_Knightley.jpg", false));
    actors.add(new Actor("George Clooney", "https://image.ibb.co/ce1t4y/George_Clooney.jpg", true));
    actors.add(new Actor("Lucy Liu", "https://image.ibb.co/dWurrd/Lucy_Liu.jpg", false));
    actors.add(new Actor("Matthew McConaughey", "https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg", true));
    actors.add(new Actor("Morgan Freeman", "https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg", true));
    actors.add(new Actor("Ryan Gosling", "https://image.ibb.co/buLLjy/Ryan_Gosling.jpg", false));
    actors.add(new Actor("Will Smith", "https://image.ibb.co/gxoUcJ/Will_Smith.jpg", false));
    actors.add(new Actor("Robert de Niro", "https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg", true));
    actors.add(new Actor("Zoe Saldana", "https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg", false));
    return actors;
  }

  public static String getActorMessage(Context context, Actor actor) {
    return context.getString(actor.hasOscar() ? R.string.actor_with_oscar : R.string.actor_no_oscar, actor.getName());
  }
}
