package com.ex.revature.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="DEPT")
    private Department dept;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="EMPLOYEE_ROLE",
        joinColumns = {@JoinColumn(name="EMP_ID")},
        inverseJoinColumns = {@JoinColumn(name="ROLE_ID")}
    )
    Set<Role> roles;
}
