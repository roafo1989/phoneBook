package GroupId.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenBundle {
  private static AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void tdInitializer() {
    td = new GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenCss_td() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "td";
      }
      public String getText() {
        return ("");
      }
    }
    ;
  }
  private static class tdInitializer {
    static {
      _instance0.tdInitializer();
    }
    static GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenCss_td get() {
      return td;
    }
  }
  public GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenCss_td td() {
    return tdInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenCss_td td;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      td(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("td", td());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'td': return this.@GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_GenBundle::td()();
    }
    return null;
  }-*/;
}
