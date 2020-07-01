/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Student;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Programming
 */
public class StudentRepository extends EntMngClass implements StudentInterface {

    @Override
    public void create(Student student) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Student student) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Student student) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Student> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Student.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Student findByID(Integer id) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT u FROM Student u WHERE u.id = :abc");
            query.setParameter("abc", id);
            return (Student) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }  
}