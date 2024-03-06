package com.banasiak.CalCount.model.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInfoId;
    private Sex sex;
    private int weight;
    private int height;
    private int age;
    private Activity activity;
    @OneToOne
    private UserMacro userMacro;
}
