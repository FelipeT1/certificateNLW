package br.com.felipeteixeira.certificationNLW.modules.students.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipeteixeira.certificationNLW.modules.students.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    // Não há necessidade de um @QUery pois a entidade já possui todos os atributos que queremos
    public Optional<StudentEntity> findByEmail(String email);

} 
