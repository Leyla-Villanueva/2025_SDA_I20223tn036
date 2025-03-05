package mx.edu.utez.MensajesError.service;


import mx.edu.utez.MensajesError.config.ApiResponse;
import mx.edu.utez.MensajesError.models.Company;
import mx.edu.utez.MensajesError.models.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.UUID;

@Service
@Transactional
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        return new ResponseEntity<>(new ApiResponse(repository.findAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findById(Long id){
        return new ResponseEntity<>(
                new ApiResponse(repository.findById(id), HttpStatus.OK),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findByUuid(UUID uuid){
        return new ResponseEntity<>(
                new ApiResponse(repository.findByUuid(uuid), HttpStatus.OK),
                HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Company company) {
        company = repository.saveAndFlush(company);
        return new ResponseEntity<>(new ApiResponse(company, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> update(Company company) {
        company = repository.saveAndFlush(company);
        return new ResponseEntity<>(new ApiResponse(company, HttpStatus.OK), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ApiResponse> delete(UUID uuid){
        repository.deleteByUuid(uuid);
        return new ResponseEntity<>(new ApiResponse(uuid, HttpStatus.OK), HttpStatus.OK);
    }
}
