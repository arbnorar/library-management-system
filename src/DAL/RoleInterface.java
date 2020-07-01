/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Role;
import java.util.List;

/**
 *
 * @author Programming
 */
public interface RoleInterface {
    void create(Role role) throws CrudFormException;
    void edit(Role role) throws CrudFormException;
    void delete(Role role) throws CrudFormException;
    List<Role> findAll() throws CrudFormException;
    Role findByID(Integer id) throws CrudFormException;
}
