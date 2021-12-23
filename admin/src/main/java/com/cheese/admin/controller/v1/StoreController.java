//package com.cheese.admin.controller.v1;
//
//import com.cheese.admin.error.ErrorCode;
//import com.cheese.admin.model.response.PaginationResponse;
//import com.cheese.admin.model.response.StoreDto;
//import com.cheese.core.domain.store.Store;
//import com.cheese.core.domain.store.StoreRepository;
//import com.cheese.core.dto.response.CheeseResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.data.web.PagedResourcesAssembler;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.cheese.admin.helper.PaginationHelper.orderByConvert;
//
//@RequestMapping("/v1/stores")
//@RestController
//public class StoreController {
//
//    @Autowired
//    StoreRepository storeRepository;
//
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'STORE_PRIVILEGE', 'STORE_DELETE_PRIVILEGE')")
//    @GetMapping
//    public ResponseEntity<PaginationResponse> findAllStores(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String ceoName,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "id,desc") String[] sort){
//        try {
//
//
//            List<Order> orders = orderByConvert(sort);
//            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//            Page<StoreDto.StoreListResponse> pageTuts;
//            if (name == null && ceoName == null)
//                pageTuts = storeRepository.findAll(pagingSort).map(StoreDto.StoreListResponse::new);
//            else if(name != null)
//                pageTuts = storeRepository.findByNameContaining(name, pagingSort).map(StoreDto.StoreListResponse::new);
//            else
//                pageTuts = storeRepository.findByCeoNameContaining(ceoName, pagingSort).map(StoreDto.StoreListResponse::new);
//
//            PaginationResponse res = new PaginationResponse(pageTuts);
//
//            return new ResponseEntity<PaginationResponse>(res, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
////    @PostConstruct
////    public void initializing() {
////        for (int i = 0; i < 200; i++) {
////            Store store = Store.builder()
////                    .storeNumber("AL"+ String.valueOf(i))
////                    .storeGroupId(1)
////                    .categoryId(1)
////                    .name("기용스토어" + String.valueOf(i))
////                    .ceoName("에디"+ String.valueOf(i))
////                    .ceoPhone("01092069357")
////                    .businessLicenseNumber("123-456-12121"+String.valueOf(i))
////                    .build();
////            storeRepository.save(store);
////        }
////    }
//}
