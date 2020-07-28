/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Issue;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programming
 */
public class IssueTableModel extends AbstractTableModel {

    List<Issue> list;
    String[] cols = {"Id", "Book ID", "Student ID", "Issue Date", "Due Date"};

    public IssueTableModel() {
    }

    public IssueTableModel(List<Issue> list) {
        this.list = list;
    }

    public void addList(List<Issue> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    public void remove(int row) {
        list.remove(row);
    }

    public Issue getIssue(int index) {
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Issue p = list.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return p.getId();
            case 1:
                return p.getBookId();
                case 2:
                return p.getStudentId();
            case 3:
                return p.getIssueDate();
            case 4:
                return p.getDueDate();          
            default:
                return null;
        }
    }
}

