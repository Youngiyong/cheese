package com.cheese.admin.service;

import com.cheese.core.domain.store.Store;
import com.cheese.core.domain.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

}
