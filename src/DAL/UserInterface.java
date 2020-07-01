/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.User;
import java.util.List;

/**
 *
 * @author Programming
 */
public interface UserInterface {
    void create(User user) throws CrudFormException;
    void edit(User user) throws CrudFormException;
    void delete(User user) throws CrudFormException;
    List<User> findAll() throws CrudFormException;
    User findByID(Integer id) throws CrudFormException;
    User loginByUsernameAndPassword(String username, String password) throws CrudFormException;
}