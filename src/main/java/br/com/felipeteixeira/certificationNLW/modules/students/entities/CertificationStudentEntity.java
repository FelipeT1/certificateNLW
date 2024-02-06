package br.com.felipeteixeira.certificationNLW.modules.students.entities;
import java.util.UUID;
import java.util.List;

public class CertificationStudentEntity {

    private UUID studentEntityId;
    private UUID id;
    private String technology;
    private int grate;
    List<answersCertificationEntity> answersCertificationEntity;

}
