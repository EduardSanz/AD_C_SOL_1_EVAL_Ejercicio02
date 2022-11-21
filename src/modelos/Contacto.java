package modelos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "contactos")
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String tipo;
    @Column
    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Contacto(String tipo, String valor) {

        this.tipo = tipo;
        this.valor = valor;
    }

    public Contacto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.equals("TELEFONO") || tipo.equals("EMAIL") ? tipo : "TELEFONO";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
