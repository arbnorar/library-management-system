/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Issue;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class IssueRepository extends EntMngClass implements IssueInterface {

    @Override
    public void create(Issue issue) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(issue);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Issue issue) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(issue);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Issue issue) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(issue);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Issue> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Issue.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Issue findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Issue u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Issue) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}
