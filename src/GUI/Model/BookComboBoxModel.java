/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Book;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Programming
 */
public class BookComboBoxModel extends AbstractListModel<Book> implements ComboBoxModel<Book> {

    private List<Book> data;
    private Book selectedItem;
    
    public BookComboBoxModel(){}
    
    public BookComboBoxModel(List<Book> data){
        this.data = data;
    }
    
    public void add(List<Book> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Book getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Book)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
