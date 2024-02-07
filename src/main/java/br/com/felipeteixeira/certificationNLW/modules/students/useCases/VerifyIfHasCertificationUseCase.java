package br.com.felipeteixeira.certificationNLW.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipeteixeira.certificationNLW.modules.students.dto.VerifyHasCertificationDTO;
import br.com.felipeteixeira.certificationNLW.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationUseCase {
    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute( VerifyHasCertificationDTO dto ){
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),dto.getTechnology());
        return !result.isEmpty();
    }
}
