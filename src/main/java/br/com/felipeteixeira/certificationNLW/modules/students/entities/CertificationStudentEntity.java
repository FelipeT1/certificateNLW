package br.com.felipeteixeira.certificationNLW.modules.students.entities;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
@Builder
public class CertificationStudentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grate;

    // Esse studentID está relacionado com a classe studentEntity,
    // então é uma "chave estrangeuira" = FK (Forengein key), precisamos relacionar esse atributo com a classe
    @JoinColumn(name = "student_id")
    private UUID studentID;


    // Definindo o relacionamento entre as classes
    // Primeiro com a composição depois com a cardinalidade para o database
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    List<AnswersCertificationEntity> answersCertificationEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
