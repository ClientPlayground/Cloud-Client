package pofou.event;

public class EventCancelable extends Event {
  private boolean cancelled;
  
  public boolean isCancelled() {
    return this.cancelled;
  }
  
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}
