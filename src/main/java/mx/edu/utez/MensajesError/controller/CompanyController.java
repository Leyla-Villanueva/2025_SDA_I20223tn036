package mx.edu.utez.MensajesError.controller;

import jakarta.validation.Valid;
import mx.edu.utez.MensajesError.config.ApiResponse;
import mx.edu.utez.MensajesError.controller.dto.CompanyDto;
import mx.edu.utez.MensajesError.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.UUID;

@RestController

@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService service;
    private static final Logger logger = LogManager.getLogger(CompanyController.class);
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        logger.info("Solicitud para obtener todas las compañías");
        return service.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CompanyDto dto) {
        logger.info("Solicitud para registrar una nueva compañía: {}", dto);
        return service.save(dto.toEntity());
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse> update(@RequestBody CompanyDto dto) {
        logger.info("Solicitud para actualizar compañía: {}", dto);
        return service.update(dto.toEntity());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse> getByUuid(@PathVariable UUID uuid) {
        logger.info("Solicitud para obtener compañía con UUID: {}", uuid);
        return service.findByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID uuid){
        logger.warn("Solicitud para eliminar compañía con UUID: {}", uuid);
        return service.delete(uuid);
    }
}
