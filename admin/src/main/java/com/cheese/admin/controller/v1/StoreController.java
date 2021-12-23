package com.cheese.admin.controller.v1;

import com.cheese.admin.error.ErrorCode;
import com.cheese.admin.exception.CustomException;
import com.cheese.admin.model.response.PaginationResponse;
import com.cheese.admin.model.response.Response;
import com.cheese.admin.model.response.StoreDto;
import com.cheese.core.domain.store.Store;
import com.cheese.core.domain.store.StoreRepository;
import com.cheese.core.dto.response.CheeseResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cheese.admin.helper.PaginationHelper.orderByConvert;

@RequestMapping("/v1/stores")
@RestController
public class StoreController {

    @Autowired
    StoreRepository storeRepository;


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_ADMIN_CUSTOM', 'STORE_DELETE_PRIVILEGE')")
    @GetMapping("/{id}")
    public ResponseEntity<Response<StoreDto.StoreResponse>> findStoreById(
            @ApiParam(value = "가맹점 아이디") @PathVariable Long id){

        try {

            Store store = storeRepository.findById(id).get();
            if(store==null){
                throw new CustomException(ErrorCode.STORE_NOT_FOUND);
            }

            Response response = Response.builder()
                                .code(ErrorCode.SUCCESS.getCode())
                                .status(ErrorCode.SUCCESS.getStatus())
                                .message(ErrorCode.SUCCESS.getMessage())
                                .data(store).build();

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_ADMIN_CUSTOM', 'STORE_DELETE_PRIVILEGE')")
    @GetMapping
    public ResponseEntity<PaginationResponse<StoreDto.StoreListResponse>> findAllStores(
            @RequestParam(required = false) @ApiParam(value = "스토어명") String name,
            @RequestParam(required = false) @ApiParam(value = "대표자명") String ceoName,
            @RequestParam(defaultValue = "1") @ApiParam(value = "페이지 번호 디폴트:1") int page,
            @RequestParam(defaultValue = "10") @ApiParam(value = "페이지 뿌려지는 갯수 디폴트:10") int size,
            @RequestParam(defaultValue = "createdAt,desc") @ApiParam(value = "정렬 데이터 예)createdAt,desc ") String[] sort){
        try {
            List<Order> orders = orderByConvert(sort);
            Pageable pagingSort = PageRequest.of(page-1, size, Sort.by(orders));

            Page<StoreDto.StoreListResponse> pageTuts;
            if (name == null && ceoName == null)
                pageTuts = storeRepository.findAll(pagingSort).map(StoreDto.StoreListResponse::new);
            else if(name != null)
                pageTuts = storeRepository.findByNameContaining(name, pagingSort).map(StoreDto.StoreListResponse::new);
            else
                pageTuts = storeRepository.findByCeoNameContaining(ceoName, pagingSort).map(StoreDto.StoreListResponse::new);

            PaginationResponse res = new PaginationResponse(pageTuts);

            return new ResponseEntity<PaginationResponse<StoreDto.StoreListResponse>>(res, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostConstruct
    public void initializing() {
        for (int i = 0; i < 200; i++) {
            Store store = Store.builder()
                    .storeNumber("AL"+ String.valueOf(i))
                    .storeGroupId(1)
                    .categoryId(1)
                    .name("기용스토어" + String.valueOf(i))
                    .ceoName("에디"+ String.valueOf(i))
                    .ceoPhone("01092069357")
                    .businessLicenseNumber("123-456-12121"+String.valueOf(i))
                    .build();
            storeRepository.save(store);
        }
    }
}
