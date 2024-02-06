package br.com.felipeteixeira.certificationNLW.modules.students.useCases;

import org.springframework.stereotype.Service;

import br.com.felipeteixeira.certificationNLW.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {
    
    public boolean execute( VerifyHasCertificationDTO dto ){
        return dto.getEmail().equals("@gmail");
    }
}
