package com.offertestortega.apiUser.model;

import com.offertestortega.apiUser.model.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    @NotNull
    private String userName;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date birthDate;

    @Column(name="country_residence")
    @NotNull
    private String countryResidence;

    @Column(name="phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
