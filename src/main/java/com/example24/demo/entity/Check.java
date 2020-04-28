package com.example24.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "check")
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "check_by_user")
    private String getCheck;
    @Column(name = "for_role")
    private String forRole;

    public Check(String getCheck, String forRole) {
        this.getCheck = getCheck;
        this.forRole = forRole;
    }
}
