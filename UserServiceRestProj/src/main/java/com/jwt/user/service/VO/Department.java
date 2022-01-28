package com.jwt.user.service.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private String departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}