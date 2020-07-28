/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Programming
 */
@Entity
@Table(name = "issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Issue.findAll", query = "SELECT i FROM Issue i"),
    @NamedQuery(name = "Issue.findById", query = "SELECT i FROM Issue i WHERE i.id = :id"),
    @NamedQuery(name = "Issue.findByIssueDate", query = "SELECT i FROM Issue i WHERE i.issueDate = :issueDate"),
    @NamedQuery(name = "Issue.findByDueDate", query = "SELECT i FROM Issue i WHERE i.dueDate = :dueDate"),
   })
public class Issue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "issueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;
    @Basic(optional = false)
    @Column(name = "dueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
   /* @Column(name = "returnBook")
    private Short returnBook;
    @Column(name = "description")
    private String description; */
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookId;
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student studentId;

    public Issue() {
    }

    public Issue(Integer id) {
        this.id = id;
    }

    public Issue(Integer id, Date issueDate, Date dueDate) {
        this.id = id;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
/*
    public Short getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Short returnBook) {
        this.returnBook = returnBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
*/
    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Issue[ id=" + id + " ]";
    }
    
}
