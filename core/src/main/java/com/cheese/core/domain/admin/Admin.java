package com.cheese.core.domain.admin;

import com.cheese.core.domain.BaseTimeEntity;
import com.cheese.core.domain.adminRole.AdminRole;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
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
public class Admin extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "admin_role_join",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AdminRole> adminRoles = new HashSet<>();

    @Column(name ="isActive", nullable = false)
    private int isActive;

    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

    @Builder
    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
