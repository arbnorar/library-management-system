/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.Book;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Programming
 */
public class BookTableModel extends AbstractTableModel {

    List<Book> list;
    String[] cols = {"Id", "Title", "ISBN", "Publisher Year", "Author ID", "Category ID"};

    public BookTableModel() {
    }

    public BookTableModel(List<Book> list) {
        this.list = list;
    }

    public void addList(List<Book> list) {
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

    public Book getBook(int index) {
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book p = list.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return p.getId();
            case 1:
                return p.getTitle();
            case 2:
                return p.getIsbn();
            case 3:
                return p.getCategory();
            case 4:
                return p.getPublisherYear();
            case 5:
                return p.getAuthorId();
            case 6:
                return p.getCategoryId();
            default:
                return null;
        }
    }
}
