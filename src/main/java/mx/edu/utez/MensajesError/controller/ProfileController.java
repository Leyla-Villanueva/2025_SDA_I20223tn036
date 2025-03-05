package mx.edu.utez.MensajesError.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {
    private static final Logger logger = LogManager.getLogger(ProfileController.class);

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/profile")
    public String getActiveProfile() {
        logger.info("Solicitud para obtener el perfil activo");
        logger.debug("Valor actual de activeProfile: {}", activeProfile);

        if (activeProfile == null || activeProfile.isEmpty()) {
            logger.warn("El perfil activo no está configurado en application.properties");
            return "No hay un perfil activo configurado";
        }

        logger.info("Perfil activo recuperado correctamente: {}", activeProfile);
        return "Perfil activo: " + activeProfile;
    }
}