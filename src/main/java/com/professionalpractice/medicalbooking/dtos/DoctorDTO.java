package com.professionalpractice.medicalbooking.dtos;

import com.professionalpractice.medicalbooking.dtos.common.DateAuditingDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorDTO extends DateAuditingDto {

    Long id;

    String name;

    String degree;

    int experience;

    String image;

    String description;

    DepartmentDTO department;
}
