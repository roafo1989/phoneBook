package GroupId.client;

import GroupId.client.ui.AddNoteDialogBox;
import GroupId.client.ui.ChangeNoteDialogBox;
import GroupId.client.ui.FilterBlock;
import GroupId.client.ui.MainPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhoneBook implements EntryPoint {
    private MainPanel mainPanel = new MainPanel();
    private AddNoteDialogBox addNoteDialogBox = new AddNoteDialogBox();
    private ChangeNoteDialogBox changeNoteDialogBox = new ChangeNoteDialogBox();
    private FilterBlock filterBlock = new FilterBlock();
    @Override
    public void onModuleLoad() {
        mainPanel.setAddNoteDialogBoxInstance(addNoteDialogBox);
        mainPanel.setChangeNoteDialogBoxInstance(changeNoteDialogBox);
        addNoteDialogBox.setMainPanel(mainPanel);
        changeNoteDialogBox.setMainPanel(mainPanel);
        filterBlock.setMainPanel(mainPanel);
        RootPanel.get("stockList").add(mainPanel);
        RootPanel.get("filter").add(filterBlock);
  }
}