package com.ex.revature.entities.dto;

import com.ex.revature.entities.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeProfileDTO {
    private String email;
    private String firstName;
    private String lastName;
    private Department department;
}
