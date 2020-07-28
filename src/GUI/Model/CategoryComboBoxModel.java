/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Category;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Programming
 */
public class CategoryComboBoxModel extends AbstractListModel<Category> implements ComboBoxModel<Category> {

    private List<Category> data;
    private Category selectedItem;
    
    public CategoryComboBoxModel(){}
    
    public CategoryComboBoxModel(List<Category> data){
        this.data = data;
    }
    
    public void add(List<Category> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Category getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Category)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}

