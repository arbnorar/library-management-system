/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Author;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programming
 */
public class AuthorTableModel extends AbstractTableModel {
    
    List <Author> list;
    String [] cols = {"First Name" , "Last Name",};
    
    public AuthorTableModel(){}
    
    public AuthorTableModel(List<Author> list){
        this.list = list;
    }
    
    public void addList(List<Author> list){
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
    
    public Author getAuthor(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getFirstName();
            case 1:
                return p.getLastName();          
            default:
                return null;
        }
    }
    
}
