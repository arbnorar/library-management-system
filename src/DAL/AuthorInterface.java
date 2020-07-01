/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Author;
import java.util.List;

/**
 *
 * @author Programming
 */


public interface AuthorInterface {
    void create(Author author) throws CrudFormException;
    void edit(Author author) throws CrudFormException;
    void delete(Author author) throws CrudFormException;
    List<Author> findAll() throws CrudFormException;
    Author findByID(Integer id) throws CrudFormException;
}