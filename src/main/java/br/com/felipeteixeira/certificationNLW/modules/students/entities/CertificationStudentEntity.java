package br.com.felipeteixeira.certificationNLW.modules.students.entities;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudentEntity {

    private UUID studentEntityId;
    private UUID id;
    private String technology;
    private int grate;
    List<answersCertificationEntity> answersCertificationEntity;

}
