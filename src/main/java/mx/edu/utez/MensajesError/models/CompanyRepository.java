package mx.edu.utez.MensajesError.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUuid(UUID uuid);
    Optional<Company> deleteByUuid(UUID uuid);
}
