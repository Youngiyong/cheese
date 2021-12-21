package com.cheese.core.domain.store;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class StoreEntity {

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
    private Boolean
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "userKeyEntity")
//    private List<ItemEntity> item = new ArrayList<>();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String encodedMetadataTocPayload;
}

