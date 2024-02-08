package br.com.felipeteixeira.certificationNLW.modules.questions.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipeteixeira.certificationNLW.modules.questions.entities.QuestionsEntity;

public interface QuestionRepository extends JpaRepository<QuestionsEntity, UUID> {
    
    // findByNome é algo do spring boot, procurará essa coluna em question entity
    List<QuestionsEntity> findByTechnology(String technology);
}
