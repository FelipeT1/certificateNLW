package br.com.felipeteixeira.certificationNLW.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResultDTO {
    private UUID id;
    private String technology;
    private String description;
    
    List<AlternativesResultDTO> alternatives;
}
