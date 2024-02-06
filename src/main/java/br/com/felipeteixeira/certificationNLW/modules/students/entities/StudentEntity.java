package br.com.felipeteixeira.certificationNLW.modules.students.entities;

import java.util.UUID;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    
    private UUID id;
    private String email;
    private List<CertificationStudentEntity> CertificationStudentEntity;



}
