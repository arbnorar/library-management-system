/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Role;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class RoleRepository extends EntMngClass implements RoleInterface {

    @Override
    public void create(Role role) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Role role) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(role);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Role role) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(role);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Role> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Role.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Role findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Role u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Role) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }   
}
