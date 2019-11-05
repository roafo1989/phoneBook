package GroupId.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;

public class FilterBlock extends Composite {
    interface FilterBlockUiBinder extends UiBinder<Widget, FilterBlock> {
    }
    private MainPanel mainPanel;
    public void setMainPanel (MainPanel mainPanelInstance){
        mainPanel = mainPanelInstance;
    }
    private static FilterBlockUiBinder filterBlockUiBinder = GWT.create(FilterBlockUiBinder.class);
    @UiField
    ListBox sortList;
    @UiField
    ListBox filterList;

    public FilterBlock() {
        initWidget(filterBlockUiBinder.createAndBindUi(this));
        sortList.addItem("");
        sortList.addItem("а-я");
        sortList.addItem("я-а");
        sortList.setVisibleItemCount(3);
        sortList.setStyleName("enjoy-input");
        sortList.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                String sortRequest = sortList.getSelectedItemText();
                mainPanel.sortTable(sortRequest);
            }
        });

        filterList.setMultipleSelect(true);
        filterList.setVisibleItemCount(3);
        filterList.addItem("");
        for (char c = 'а'; c <= 'я'; c++) {
            filterList.addItem(String.valueOf(c));
        }
        filterList.setStyleName("enjoy-input");
        filterList.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                ArrayList<String> listForSort = new ArrayList<>();
                for (int i = 0; i < filterList.getItemCount(); i++) {
                    if (filterList.isItemSelected(i)) listForSort.add(filterList.getItemText(i));
                }
                mainPanel.filterTable(listForSort);
            }
        });
    }
}