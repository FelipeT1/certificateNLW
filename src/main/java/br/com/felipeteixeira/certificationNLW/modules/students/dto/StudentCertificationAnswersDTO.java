package br.com.felipeteixeira.certificationNLW.modules.students.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Created so the StudentCertificationAnswersService can have the 
// student email, tech and alternative
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCertificationAnswersDTO {
    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionAnswers;

}
