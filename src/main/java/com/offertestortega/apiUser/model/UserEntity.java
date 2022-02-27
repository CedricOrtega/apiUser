package com.offertestortega.apiUser.model;

import com.offertestortega.apiUser.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    @NotNull
    private String userName;

    @Column(name="birthdate")
    @NotNull
    private LocalDate birthDate;

    @Column(name="country_residence")
    @NotNull
    private String countryResidence;

    @Column(name="phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
