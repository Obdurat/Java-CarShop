package com.obdurat.carshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class CarEntity {    
     
    @Id
    private String _id;

    @NonNull
    private String _model;

    @NonNull
    private int _year;

    @NonNull
    private String _color;

    @NonNull
    private float _buyValue;

    @NonNull
    private Boolean _status;

    @NonNull
    private int _doorsQty;
    
    @NonNull
    private int _seatsQty;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getModel() {
        return _model;
    }

    public void setModel(String model) {
        this._model = model;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        this._year = year;
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        this._color = color;
    }

    public float getBuyValue() {
        return _buyValue;
    }

    public void setBuyValue(float buyValue) {
        this._buyValue = buyValue;
    }

    public Boolean getStatus() {
        return _status;
    }

    public void setStatus(Boolean status) {
        this._status = status;
    }

    public int getDoorsQty() {
        return _doorsQty;
    }

    public void setDoorsQty(int doorsQty) {
        this._doorsQty = doorsQty;
    }

    public int getSeatsQty() {
        return _seatsQty;
    }

    public void setSeatsQty(int seatsQty) {
        this._seatsQty = seatsQty;
    }
}
