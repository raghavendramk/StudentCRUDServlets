package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import dto.Student;



public class StudentDao {
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();

public void save(Student student)
{
	transaction.begin();
	manager.persist(student);
	transaction.commit();
}

public  List<Student> fetechAll()
{
return manager.createQuery("select x from Student x").getResultList();
}

public Student find(int id) {
	return manager.find(Student.class, id);
}
public void Delete(int id) {
	transaction.begin();
	manager.remove(manager.find(Student.class, id));
	transaction.commit();
}
public void update(Student student) {
	transaction.begin();
	manager.merge(student);
	transaction.commit();
}
}
