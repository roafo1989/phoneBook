package GroupId.client.ui;

public class FilterBlock_FilterBlockUiBinderImpl_TemplateImpl implements GroupId.client.ui.FilterBlock_FilterBlockUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(java.lang.String arg0,java.lang.String arg1) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<h3>Сортировка и фильтр</h3> <table> <tr> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> </td> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </td> </tr> </table>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
