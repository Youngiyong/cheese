package com.cheese.core.domain.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // internal

    @Column(nullable = false, length = 255)
    private String itemNumber;

    @Column(columnDefinition = "TEXT")
    private String legalHeader;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "userKeyEntity")
//    private List<ItemEntity> item = new ArrayList<>();

    @Column(columnDefinition = "TEXT", nullable = false)
    private String encodedMetadataTocPayload;
}

