package pofou.gui.hud;

public interface IRenderer extends IRendererConfig {
  int getWidth();
  
  int getHeight();
  
  void render(ScreenPosition paramScreenPosition);
  
  default void renderDummy(ScreenPosition pos) {
    render(pos);
  }
  
  default boolean isEnabled() {
    return true;
  }
}
