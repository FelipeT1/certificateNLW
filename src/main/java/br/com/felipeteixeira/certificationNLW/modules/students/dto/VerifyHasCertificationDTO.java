package br.com.felipeteixeira.certificationNLW.modules.students.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyHasCertificationDTO {
    private String email;
    private String technology;
}
