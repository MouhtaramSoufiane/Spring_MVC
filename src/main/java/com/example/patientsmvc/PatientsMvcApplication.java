package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class PatientsMvcApplication {
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner Start(){
        return args -> {
            patientRepository.save(new Patient(null,"soufiane",false,new Date(),12));
            patientRepository.save(new Patient(null,"yassine",true,new Date(),88));
            patientRepository.save(new Patient(null,"khalid",false,new Date(),55));
            patientRepository.save(new Patient(null,"youssef",true,new Date(),23));
            patientRepository.save(new Patient(null,"wafae",false,new Date(),45));


            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getId());
                System.out.println(patient.getName());
                System.out.println(patient.getMalade());
                System.out.println(patient.getDate_naissance());
            });




        };
    }

}
