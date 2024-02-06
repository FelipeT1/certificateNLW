package br.com.felipeteixeira.certificationNLW.modules.students.entities;

import java.util.UUID;


public class answersCertificationEntity {
    
    private UUID id;
    private UUID studentEntityId;
    private UUID certificationEntityId;
    private UUID questionId;
    private UUID answerId;
    private boolean isCorrect;

}
