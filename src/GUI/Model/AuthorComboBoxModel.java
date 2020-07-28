/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Author;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Programming
 */
public class AuthorComboBoxModel extends AbstractListModel<Author> implements ComboBoxModel<Author> {

    private List<Author> data;
    private Author selectedItem;
    
    public AuthorComboBoxModel(){}
    
    public AuthorComboBoxModel(List<Author> data){
        this.data = data;
    }
    
    public void add(List<Author> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Author getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Author)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}

