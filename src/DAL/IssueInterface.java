/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Issue;
import java.util.List;

/**
 *
 * @author Programming
 */

public interface IssueInterface {
    void create(Issue issue) throws CrudFormException;
    void edit(Issue issue) throws CrudFormException;
    void delete(Issue issue) throws CrudFormException;
    List<Issue> findAll() throws CrudFormException;
    Issue findByID(Integer id) throws CrudFormException;
}