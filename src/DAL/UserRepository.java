/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.User;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class UserRepository extends EntMngClass implements UserInterface {

    @Override
    public void create(User user) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(User user) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(User user) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<User> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("User.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public User findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public User loginByUsernameAndPassword(String username, String password) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :us AND u.password=:psw");
            query.setParameter("us", username);
            query.setParameter("psw", password);
            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}