package br.com.felipeteixeira.certificationNLW.modules.questions.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipeteixeira.certificationNLW.modules.questions.dto.AlternativesResultDTO;
import br.com.felipeteixeira.certificationNLW.modules.questions.dto.QuestionResultDTO;
import br.com.felipeteixeira.certificationNLW.modules.questions.entities.AlternativesEntity;
import br.com.felipeteixeira.certificationNLW.modules.questions.entities.QuestionsEntity;
import br.com.felipeteixeira.certificationNLW.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology);
        var toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionsEntity question){
        var questionResultDTO = QuestionResultDTO
        .builder()
        .id(question.getId())
        .technology(question.getTechnology())
        .description(question.getDescription())
        .build();

        List<AlternativesResultDTO> alternativesResultDTOs = question
        .getAlternativesEntity()
        .stream()
        .map(alternative -> mapAlternativesDTO(alternative))
        .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOs);

        return questionResultDTO;
    }
    
    static AlternativesResultDTO mapAlternativesDTO(AlternativesEntity alternativesEntity){
        return AlternativesResultDTO
        .builder()
        .id(alternativesEntity.getId())
        .description(alternativesEntity.getDescription())
        .build();
        
    }
}
