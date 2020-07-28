/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Student;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Programming
 */
public class StudentComboBoxModel extends AbstractListModel<Student> implements ComboBoxModel<Student> {

    private List<Student> data;
    private Student selectedItem;
    
    public StudentComboBoxModel(){}
    
    public StudentComboBoxModel(List<Student> data){
        this.data = data;
    }
    
    public void add(List<Student> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Student getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Student)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}