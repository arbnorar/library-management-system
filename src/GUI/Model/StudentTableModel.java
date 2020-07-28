/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programming
 */

public class StudentTableModel extends AbstractTableModel {
    
    List <Student> list;
    String [] cols = {"Student Id" , "First Name", "Last Name", "Faculty Name"};
    
    public StudentTableModel(){}
    
    public StudentTableModel(List<Student> list){
        this.list = list;
    }
    
    public void addList(List<Student> list){
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
    
    public Student getStudent(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getFirstName();    
                case 2:
                return p.getLastName();  
                    case 3:
                return p.getFacultyName();  
            default:
                return null;
        }
    }
    
}
