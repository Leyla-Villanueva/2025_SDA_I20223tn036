package mx.edu.utez.MensajesError.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.MensajesError.models.Company;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

public class CompanyDto {
    private String razon_social;
    private String rfc;
    private String telefono;
    private String contacto;
    private String correo;

    public Company toEntity() {
        return new Company(UUID.randomUUID(),razon_social,rfc,telefono,contacto,correo);
    }
}
