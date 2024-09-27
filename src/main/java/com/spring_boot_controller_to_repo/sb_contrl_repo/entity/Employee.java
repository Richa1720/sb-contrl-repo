package com.spring_boot_controller_to_repo.sb_contrl_repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Accessors(chain=true)
@Data
@Entity(name="employee_table")
//@Table(name="employee_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @Column(name="emp_name",unique=true, nullable=false, length=60)
    private String empName;

    @NotNull  //deprecated
    private int phnNo;

    @Column(name="date_of_joining")
    private Date doj;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name="date_of_leave")
    private LocalDate dol;

    @Column(name="project_date")
    private OffsetDateTime proDate;

}
