package br.com.felipeteixeira.certificationNLW.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipeteixeira.certificationNLW.modules.students.dto.StudentCertificationAnswersDTO;
import br.com.felipeteixeira.certificationNLW.modules.students.dto.VerifyHasCertificationDTO;
import br.com.felipeteixeira.certificationNLW.modules.students.entities.CertificationStudentEntity;
import br.com.felipeteixeira.certificationNLW.modules.students.services.StudentCertificationAnswersService;
import br.com.felipeteixeira.certificationNLW.modules.students.services.VerifyIfHasCertificationService;




@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private VerifyIfHasCertificationService useCase;

    @Autowired
    private StudentCertificationAnswersService service;
   
    @PostMapping("/verifyIfHasCertification")
    public String verifyHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){
        System.out.println(verifyHasCertificationDTO);

        if(useCase.execute(verifyHasCertificationDTO)){
            return "NÃO PODE FAZER A PROVA!";
        }

        return "Usuário pode fazer a prova!";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAsnwer(@RequestBody StudentCertificationAnswersDTO dto) {
        try{
            var result = service.execute(dto);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
