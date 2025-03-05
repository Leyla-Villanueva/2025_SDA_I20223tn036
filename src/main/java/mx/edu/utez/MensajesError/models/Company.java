package mx.edu.utez.MensajesError.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "company")
@NoArgsConstructor
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();
    @Column(length = 100, nullable = false)
    private String razon_social;
    @Column(length = 12, nullable = false, unique = true)
    private String rfc;
    @Column(length = 14, nullable = false)
    private String telefono;
    @Column(length = 100, nullable = false)
    private String contacto;
    @Column(length = 320, nullable = false)
    private String correo;

    public Company(Long id, String razon_social, String rfc, String telefono, String contacto, String correo) {
        this.id = id;
        this.razon_social = razon_social;
        this.rfc = rfc;
        this.telefono = telefono;
        this.contacto = contacto;
        this.correo = correo;
    }

    public Company(String razon_social, String rfc, String telefono, String contacto, String correo) {
        this.razon_social = razon_social;
        this.rfc = rfc;
        this.telefono = telefono;
        this.contacto = contacto;
        this.correo = correo;
    }

    public Company(UUID uuid, String razon_social, String rfc, String telefono, String contacto, String correo) {
        this.uuid = uuid;
        this.razon_social = razon_social;
        this.rfc = rfc;
        this.telefono = telefono;
        this.contacto = contacto;
        this.correo = correo;
    }
}