/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Category;
import java.util.List;
 
/**
 *
 * @author Programming
 */
public interface CategoryInterface {
    void create(Category category) throws CrudFormException;
    void edit(Category category) throws CrudFormException;
    void delete(Category category) throws CrudFormException;
    List<Category> findAll() throws CrudFormException;
    Category findByID(Integer id) throws CrudFormException;
}