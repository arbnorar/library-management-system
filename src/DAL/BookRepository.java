/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Book;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class BookRepository extends EntMngClass implements BookInterface {

    @Override
    public void create(Book book) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Book book) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Book book) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Book> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Book.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Book findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Book u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Book) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}
