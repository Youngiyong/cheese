package com.cheese.core.domain.itemImage;


import javax.persistence.*;

import com.cheese.core.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_images")
public class ItemImageEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // internal

    private Integer itemId;

    @Column(nullable = false, length = 16)
    private String type;

    @Column(nullable = false, length = 1024)
    private String original;

    @Column
    private Boolean sort;

    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;
}
