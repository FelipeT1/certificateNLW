package br.com.felipeteixeira.certificationNLW.modules.students.services;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipeteixeira.certificationNLW.modules.questions.repositories.QuestionRepository;
import br.com.felipeteixeira.certificationNLW.modules.students.dto.StudentCertificationAnswersDTO;
import br.com.felipeteixeira.certificationNLW.modules.students.entities.AnswersCertificationEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.entities.CertificationStudentEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.entities.StudentEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.repositories.CertificationStudentRepository;
import br.com.felipeteixeira.certificationNLW.modules.students.repositories.StudentRepository;


@Service
public class StudentCertificationAnswersService {
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CertificationStudentRepository certificationRepository;
    



    public CertificationStudentEntity execute(StudentCertificationAnswersDTO dto){

        // Busca a questão e suas alternativas para saber qual é a correta
        var questions = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswersCertificationEntity> answersCertifications = new ArrayList<>();

        AtomicInteger correctAnswersCounter = new AtomicInteger(0);

        dto.getQuestionAnswers()
        .stream()
        .forEach(questionAnswer -> {
            var sameID = questions.stream().filter(id -> id.getId()
            .equals(questionAnswer.getQuestionID()))
            .findFirst()
            .get();
            
            // gets correct answer from datasource
            var correct = sameID.getAlternativesEntity().stream().filter(x->x.isCorrect()).findFirst().get();

            // If correct answer id is equal to chosen alternative
            if(correct.getId().equals(questionAnswer.getAlternativeID())){
                questionAnswer.setCorrect(true);
                correctAnswersCounter.incrementAndGet();
            }
            else{
                questionAnswer.setCorrect(false);

            }

            var answersCertificationEntity = AnswersCertificationEntity
            .builder()
            .answerID(questionAnswer.getAlternativeID())
            .questionID(questionAnswer.getQuestionID())
            .isCorrect(questionAnswer.isCorrect())
            .build();

            answersCertifications.add(answersCertificationEntity);

        });

        // verifica se o estudante existe pelo email
        // se não achar no banco de dados, o aluno será cadastrado

        var student = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;
        if(student.isEmpty()){
            var studentCreated = StudentEntity
            .builder()
            .email(dto.getEmail())
            .build();

            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
            
        }
        else{
            studentID = student.get().getId();
        }


        var certificationStudentEntity = CertificationStudentEntity
        .builder()
        .studentID(studentID)
        .technology(dto.getTechnology())
        .grate(correctAnswersCounter.get())
        .build();
        var certificationStudentCreated = certificationRepository.save(certificationStudentEntity);

        answersCertifications.stream().forEach(answerCertifications -> {
            answerCertifications.setAnswerID(certificationStudentEntity.getId());
            answerCertifications.setCertificationStudentEntity(certificationStudentEntity);
        });

        certificationStudentEntity.setAnswersCertificationEntity(answersCertifications);

        certificationRepository.save(certificationStudentEntity);

        return certificationStudentCreated;
    }
}
