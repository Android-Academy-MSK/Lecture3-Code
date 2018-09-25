package ru.androidacademy.msk.lists.data;

public class Actor {

  private final String name;
  private final String avatarUrl;
  private final boolean hasOscar;

  public Actor(String name, String avatarUrl, boolean hasOscar) {
    this.name = name;
    this.avatarUrl = avatarUrl;
    this.hasOscar = hasOscar;
  }

  public String getName() {
    return name;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public boolean hasOscar() {
    return hasOscar;
  }

  @Override
  public String toString() {
    return "Actor{" +
        "name='" + name + '\'' +
        ", avatarUrl=" + avatarUrl +
        ", hasOscar=" + hasOscar +
        '}';
  }
}
