package com.c.ecart;

import java.util.List;

import com.c.ecart.model.Category;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GenericResponse<T> {

    private final Boolean success;
    private T data;
    private List<T> dataList;
    private final String message;
    
 // Keep the existing 'data' method for a single item
    public GenericResponse<T> dataList(T data) {
        this.data = data;
        return this;
    }

    // New 'dataList' method for a list of items
    public GenericResponse<T> dataList(List<T> dataList) {
        this.dataList = dataList;
        return this;
    }
    

}
