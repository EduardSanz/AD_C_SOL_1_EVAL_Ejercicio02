import modelos.Contacto;
import modelos.Direccion;
import modelos.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Persona persona = new Persona("Edu", "Sanz", new Date());
        Contacto c1 = new Contacto("TELEFONO", "123456");
        Contacto c2 = new Contacto("EMAIL", "eduard@cieep.com");
        Direccion d1 = new Direccion("dgfsd","dsfsdfg","dfsdg","sdfsdf", "sfsdfs");
        persona.setDireccion(d1);
        persona.getContactos().add(c1);
        persona.getContactos().add(c2);

        c1.setPersona(persona);
        c2.setPersona(persona);
        d1.setPersona(persona);


        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(c1);
        session.persist(c2);
        session.persist(d1);
        session.persist(persona);


        session.getTransaction().commit();;
        session.close();
    }
}