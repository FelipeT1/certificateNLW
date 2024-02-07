package br.com.felipeteixeira.certificationNLW.modules.students.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

import br.com.felipeteixeira.certificationNLW.modules.students.entities.CertificationStudentEntity;

//@Repository é redundante pois essa interface herda de uma interface relacionada a repositorios
public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {
    
    
    // O 'c' é um apelido de certification, std é o apelido de studentEntity
    @Query("SELECT c FROM certifications c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);
}