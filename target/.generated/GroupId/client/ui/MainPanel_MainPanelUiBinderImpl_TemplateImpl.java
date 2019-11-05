package GroupId.client.ui;

public class MainPanel_MainPanelUiBinderImpl_TemplateImpl implements GroupId.client.ui.MainPanel_MainPanelUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<table> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> </td> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </td> </table> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'></span>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
