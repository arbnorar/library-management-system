/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Book;
import java.util.List;

/**
 *
 * @author Programming
 */
public interface BookInterface {
    void create(Book book) throws CrudFormException;
    void edit(Book book) throws CrudFormException;
    void delete(Book book) throws CrudFormException;
    List<Book> findAll() throws CrudFormException;
    Book findByID(Integer id) throws CrudFormException;
}
