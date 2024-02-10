package br.com.felipeteixeira.certificationNLW.modules.students.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "anwers_certification_students")
@Builder
public class AnswersCertificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Todos esses atributos para baixo
    // São FK
    // Por isso os relacionamentos devem ser definidos

    @Column(name = "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;


    @Column(name = "certification_id")
    private UUID certificationID;

    @ManyToOne
    // Os outros parâmetros além do nome
    // Servem para classificar essa coluna como uma referência
    // Assim ela não é duplicada
    @JoinColumn(name = "certification_id", insertable = false, updatable = false)
    private CertificationStudentEntity certificationStudentEntity;



    @Column(name = "question_id")
    private UUID questionID;

    @Column(name = "answer_id")
    private UUID answerID;


    @Column(name = "is_correct")
    private boolean isCorrect;


    // Para saber quando tudo foi criado
    // O spring vai criar essa coluna com a data no database
    // Sem precisar instanciar
    @CreationTimestamp
    private LocalDateTime createdAt;
}
