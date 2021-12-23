package com.cheese.admin.model.response;

import com.cheese.core.domain.store.Store;
import lombok.Getter;

public class StoreDto {

    @Getter
    public static class StoreListResponse {
        private Long id;
        private String storeNumber;
        private String name;
        private String ceoName;
        private String fax;
        private String address;
        private boolean isActive;
        private String bankCode;

        public StoreListResponse(Store entity){
            this.id = entity.getId();
            this.storeNumber = entity.getStoreNumber();
            this.name = entity.getName();
            this.ceoName = entity.getCeoName();
            this.fax = entity.getFax();
            this.address = entity.getAddress();
            this.isActive = entity.getIsActive();
            this.bankCode = entity.getBankCode();
        }
    }

}
