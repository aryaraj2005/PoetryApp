package com.example.vedaversa;

import java.util.List;

public class fetchPoetryModel {
    String status;
    String message;
    List<poetryModel> data;

    public fetchPoetryModel() {
    }

    public fetchPoetryModel(String status, String message, List<poetryModel> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<poetryModel> getData() {
        return data;
    }

    public void setData(List<poetryModel> data) {
        this.data = data;
    }
}
