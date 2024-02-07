package br.com.felipeteixeira.certificationNLW.modules.students.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswersCertificationEntity {
   
    private UUID id;

    private UUID studentEntityId;

    private UUID certificationEntityId;
    private UUID questionId;
    private UUID answerId;
    private boolean isCorrect;

}
