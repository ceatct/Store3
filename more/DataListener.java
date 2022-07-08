package com.example.store;

import java.util.List;

public interface DataListener<ApiResponce> {

    void DListener(List<StoreDataProduct> list, String message);
    void onError(String message);

}
