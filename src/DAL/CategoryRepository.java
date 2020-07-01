/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Category;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class CategoryRepository extends EntMngClass implements CategoryInterface {

    @Override
    public void create(Category category) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Category category) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Category category) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(category);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Category> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Category.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Category findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Category u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Category) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}