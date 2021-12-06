package com.cheese.core.domain.users;


import com.cheese.core.domain.BaseTimeEntity;
import com.cheese.core.domain.adminRole.AdminRole;
import com.cheese.core.domain.userRoles.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(	name = "admin",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "cp", nullable = false, length = 20)
    private String phone;

    @Column(name = "sex", nullable = false, length = 1)
    private String sex;

//    @Column(name = "birth_year", nullable = false, length = 4)
//    private String birthYear;
//
//    @Column(name = "birth_month", nullable = false, length = 2)
//    private String birthMonth;
//
//    @Column(name = "birth_day", nullable = false, length = 2)
//    private String birthDay;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_role_join",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRoles = new HashSet<>();

    @Column(name ="isActive", nullable = false)
    private int isActive;

    @LastModifiedDate
    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

    @Builder
    public User(String username, String email, String password, String roles) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
