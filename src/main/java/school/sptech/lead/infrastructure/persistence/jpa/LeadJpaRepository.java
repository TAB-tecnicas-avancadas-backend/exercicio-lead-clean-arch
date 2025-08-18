package school.sptech.lead.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeadJpaRepository extends JpaRepository<LeadEntity, UUID> {
}
