package com.obdurat.carshop.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarEntity {    
     
    @Id
    @Pattern(regexp = "^([a-zA-Z0-9]){24}")
    private String _id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String _model;

    @Min(1990)
    @Max(2022)
    private int _year;
    
    @NotBlank
    private String _color;
    
    @DecimalMin("1000")
    private float _buyValue;
    
    private Boolean _status;

    @Min(2)
    @Max(4)
    private int _doorsQty;
    
    @Min(2)
    @Max(7)
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
