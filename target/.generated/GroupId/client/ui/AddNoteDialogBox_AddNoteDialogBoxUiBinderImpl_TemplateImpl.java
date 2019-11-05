package GroupId.client.ui;

public class AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl_TemplateImpl implements GroupId.client.ui.AddNoteDialogBox_AddNoteDialogBoxUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2,java.lang.String arg3,java.lang.String arg4) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<table> <tr> <td> Имя: </td> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> </td> </tr> <tr> <td> Телефон: </td> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </td> </tr> <tr> <td> Комментарий: </td> <td> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'></span> </td> </tr> </table> <div align='right'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg3));
    sb.append("'></span> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg4));
    sb.append("'></span> </div>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
