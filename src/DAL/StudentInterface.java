/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Student;
import java.util.List;

/**
 *
 * @author Programming
 */
public interface StudentInterface {
    void create(Student student) throws CrudFormException;
    void edit(Student student) throws CrudFormException;
    void delete(Student student) throws CrudFormException;
    List<Student> findAll() throws CrudFormException;
    Student findByID(Integer id) throws CrudFormException;
}