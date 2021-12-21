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

    @Column(columnDefinition = "TEXT")
    private String legalHeader;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "userKeyEntity")
//    private List<ItemEntity> item = new ArrayList<>();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String encodedMetadataTocPayload;
}

