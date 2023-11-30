package application;

import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        Person p1 = new Person(null, "Joana", "joana@gmail.com");
        Person p2 = new Person(null, "Victor", "victor@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // INSERIR

        em.getTransaction().begin(); // Inicia transação com BD
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit(); // Confirma transação com BD

        // RECUPERAR

        Person pGet = em.find(Person.class, 1);
        System.out.println(pGet);

        // DELETAR

        em.getTransaction().begin();
        Person pDelete = em.find(Person.class, 2);
        em.remove(pDelete);
        em.getTransaction().commit();

        System.out.println("Pronto");
        em.close();
        emf.close();
    }
}
