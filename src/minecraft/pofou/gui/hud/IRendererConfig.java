package pofou.gui.hud;

public interface IRendererConfig {
  void save(ScreenPosition paramScreenPosition);
  
  ScreenPosition load();
}
