package com.cheese.core.domain.store;


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
@Table(name = "stores")
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // internal

    @Column(nullable = false, length = 20)
    private String storeNumber;

    @Column
    private Integer storeGroupId;

    @Column
    private Integer categoryId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @Column(nullable = false, length = 300)
    private String businessLicenseNumber;

    @Column(nullable = false, length = 20)
    private String ceoName;

    @Column(nullable = false, length = 20)
    private String ceoPhone;

    @Column(length = 20)
    private String fax;

    @Column(length = 256)
    private String address;

    @Column(length = 256)
    private String addressExtra;

    @Column(length = 256)
    private String homepageUrl;

    @Column
    private Boolean isApprove;

    @Column
    private Boolean isActive;

    @Column
    private Boolean isHoliday;

    @Column
    private Boolean isContractBond;

    @Column
    private Boolean isBlackList;

    @Column(length = 32)
    private String bankName;

    @Column(length = 32)
    private String bankCode;

    @Column(length = 32)
    private String bankAccount;

    @Column(length = 100)
    private String bankAccountName;

    @Column(length = 20)
    private String lat;

    @Column(length = 20)
    private String lng;

    @Column
    private LocalDateTime workStart;

    @Column
    private LocalDateTime workEnd;

    @Column
    private Float discountItemsReward;

    @Column(length = 200)
    private String deletedReason;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "userKeyEntity")
//    private List<ItemEntity> item = new ArrayList<>();
    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;
}

