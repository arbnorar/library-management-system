/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Category;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programming
 */
public class CategoryTableModel extends AbstractTableModel {
    
    List <Category> list;
    String [] cols = {"Id" , "Name", "Description"};
    
    public CategoryTableModel(){}
    
    public CategoryTableModel(List<Category> list){
        this.list = list;
    }
    
    public void addList(List<Category> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Category getCategory(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getName();
            case 2:
                return p.getDescription();
            default:
                return null;
        }
    }
}
