/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Author;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class AuthorRepository extends EntMngClass implements AuthorInterface {

    @Override
    public void create(Author author) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Author author) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Author author) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(author);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Author> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Author.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Author findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Author u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Author) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}
