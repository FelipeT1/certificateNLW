package br.com.felipeteixeira.certificationNLW.modules.certifications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipeteixeira.certificationNLW.modules.students.entities.CertificationStudentEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.repositories.CertificationStudentRepository;

@Service
public class Top10RankingService {
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;
    
    public List<CertificationStudentEntity> execute(){
        var result = this.certificationStudentRepository.findTop10ByOrderByGradeDesc();
        return result;
    }
}
