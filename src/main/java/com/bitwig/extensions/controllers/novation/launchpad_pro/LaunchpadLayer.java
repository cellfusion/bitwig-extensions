package com.bitwig.extensions.controllers.novation.launchpad_pro;

import com.bitwig.extension.controller.api.HardwareActionBindable;
import com.bitwig.extensions.framework.Layer;

public class LaunchpadLayer extends Layer
{
   public LaunchpadLayer(final LaunchpadProControllerExtension launchpad, final String name)
   {
      super(launchpad.getLayers(), name);
      mLaunchpad = launchpad;
   }

   void bindPressed(final Button bt, final Runnable runnable)
   {
      bindPressed(bt.getButton(), runnable);
   }

   void bindReleased(final Button bt, final Runnable runnable)
   {
      bindReleased(bt.getButton(), runnable);
   }

   void bindPressed(final Button bt, final HardwareActionBindable bindable)
   {
      bindPressed(bt.getButton(), bindable);
   }

   void bindReleased(final Button bt, final HardwareActionBindable bindable)
   {
      bindReleased(bt.getButton(), bindable);
   }

   void bindOverlay(final Button bt, final Overlay overlay)
   {
      bindPressed(bt, () -> mLaunchpad.setBottomOverlay(overlay, true, bt));
      bindReleased(bt, () -> mLaunchpad.setBottomOverlay(overlay, false, bt));
   }

   void bindMode(final Button bt, final Mode mode)
   {
      assert mode != null;
      bindPressed(bt, () -> mLaunchpad.setMode(mode));
   }

   void bindLayer(final Button button, final Layer layer)
   {
      bindPressed(button, layer.getActivateAction());
      bindReleased(button, layer.getDeactivateAction());
   }

   private final LaunchpadProControllerExtension mLaunchpad;
}
