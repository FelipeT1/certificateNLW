package br.com.felipeteixeira.certificationNLW.modules.students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipeteixeira.certificationNLW.modules.questions.repositories.QuestionRepository;
import br.com.felipeteixeira.certificationNLW.modules.students.dto.StudentCertificationAnswersDTO;
import br.com.felipeteixeira.certificationNLW.modules.students.entities.CertificationStudentEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.repositories.StudentRepository;


@Service
public class StudentCertificationAnswersService {
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public StudentCertificationAnswersDTO execute(StudentCertificationAnswersDTO dto){

        // Busca a questão e suas alternativas para saber qual é a correta
        var questions = questionRepository.findByTechnology(dto.getTechnology());

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
            }
            else{
                questionAnswer.setCorrect(false);

            }
        });
        

        return dto;
    }
}
