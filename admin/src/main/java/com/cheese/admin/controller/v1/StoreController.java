package com.cheese.admin.controller.v1;

import com.cheese.core.domain.store.Store;
import com.cheese.core.domain.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/v1/stores")
@RestController
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllStores(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort){
        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Store> stores = new ArrayList<Store>();
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Store> pageTuts;
            if (name == null)
                pageTuts = storeRepository.findAll(pagingSort);
            else
                pageTuts = storeRepository.findByNameContaining(name, pagingSort);

            stores = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("stores", stores);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostConstruct
//    public void initializing() {
//        for (int i = 0; i < 200; i++) {
//            Store store = Store.builder()
//                    .storeNumber("AL"+ String.valueOf(i))
//                    .storeGroupId(1)
//                    .categoryId(1)
//                    .name("기용스토어" + String.valueOf(i))
//                    .ceoName("에디"+ String.valueOf(i))
//                    .ceoPhone("01092069357")
//                    .businessLicenseNumber("123-456-12121"+String.valueOf(i))
//                    .build();
//            storeRepository.save(store);
//        }
//    }
}
