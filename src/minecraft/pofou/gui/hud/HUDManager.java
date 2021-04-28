package pofou.gui.hud;

import com.google.common.collect.Sets;

import pofou.event.EventTarget;
import pofou.event.EventManager;
import pofou.event.RenderEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import net.minecraft.client.Minecraft;


public class HUDManager {
  private static HUDManager instance = null;
  
  public static HUDManager getInstance() {
    if (instance != null)
      return instance; 
    instance = new HUDManager();
    EventManager.register(instance);
    return instance;
  }
  
  private final Set<IRenderer> registeredRenderers = Sets.newHashSet();
  
  private final Minecraft mc = Minecraft.getMinecraft();
  
  public void register(IRenderer... renderers) {
    this.registeredRenderers.addAll(Arrays.asList(renderers));
  }
  
  public void unregister(IRenderer... renderers) {
    this.registeredRenderers.removeAll(Arrays.asList((Object[])renderers));
  }
  
  public Collection<IRenderer> getRegisteredRenderers() {
    return Sets.newHashSet(this.registeredRenderers);
  }
  
  public void openConfigScreen() {
    this.mc.displayGuiScreen(new HUDConfigScreen(this));
  }
  
  @EventTarget
  public void onRender(RenderEvent event) {
    if (this.mc.currentScreen == null || this.mc.currentScreen instanceof net.minecraft.client.gui.inventory.GuiContainer) {
      if (this.mc.gameSettings.showDebugInfo)
        return; 
      for (IRenderer registeredRenderer : this.registeredRenderers)
        callRenderer(registeredRenderer); 
    } 
  }
  
  public void callRenderer(IRenderer renderer) {
    if (!renderer.isEnabled())
      return; 
    ScreenPosition pos = renderer.load();
    if (pos == null)
      pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D); 
    renderer.render(pos);
  }
}
