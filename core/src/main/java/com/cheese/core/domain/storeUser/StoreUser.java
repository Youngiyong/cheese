package com.cheese.core.domain.storeUser;


import com.cheese.core.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_users")
public class StoreUser extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // internal

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @Column(nullable = false, length = 1)
    private String cp;

    @Column(length = 4)
    private String birthYear;

    @Column(length = 2)
    private String birthMonth;

    @Column(length = 2)
    private String birthDay;

    @Column
    private Boolean isStaff;

    @Column
    private Boolean isApprove;

    @Column
    private Boolean isReceivePush;

    @Column
    private Boolean isReceiveCheese;

    @Column
    private Boolean isReceivePay;

    @Column
    private Boolean isReceivePromotion;

    @Column(length = 200)
    private String deletedReason;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "userKeyEntity")
//    private List<ItemEntity> item = new ArrayList<>();
    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;
}

