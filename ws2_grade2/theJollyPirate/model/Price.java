package model;

import model.boats.Boat;

import java.io.Serializable;

public class Price implements Serializable {
    private double price = 0;
    private final int sailboat = 500;
    private final int motorsailer = 600; //Risk of oil-leakage - environment price
    private final int kayak_canoe = 150;
    private final int other = 350;
    private final int underFive = 0;
    private final int fiveToTen = 100;
    private final int overTen = 200;

    public Price() {
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(Boat boat){
        String type = boat.getType();
        double length = boat.getLength();
        if(type.equalsIgnoreCase("sailboat")){
            if (length<=5){this.price = this.sailboat + this.underFive;}
            else if (length>5 & boat.getLength() <= 10){this.price =  this.sailboat + this.fiveToTen;}
            else
                this.price = this.sailboat + this.overTen;}
        else if(type.equalsIgnoreCase("motorsailer")){
            if (length<=5){this.price =  this.motorsailer + this.underFive;}
            else if (length>5 & boat.getLength() <= 10){this.price = this.motorsailer + this.fiveToTen;}
            else
                this.price = this.motorsailer + this.overTen;}
        else if(type.equalsIgnoreCase("kayak_canoe")) {
            this.price = this.kayak_canoe;
        }

        else if(type.equalsIgnoreCase("other")){
            if (length<=5){this.price =  this.other + this.underFive;}
            else if (length>5 & boat.getLength() <= 10){this.price = this.other + this.fiveToTen;}
            else
                this.price =  this.other + this.overTen;}

    }

    public void setUpdatePrice(Boat boat, String prevType, double prevLength) {
        double lengthDifference = boat.getLength()-prevLength;
        double typeDifference = 0;
        if(!boat.getType().equals(prevType))
            typeDifference = findDifference(boat.getType(), prevType);
        this.price =  typeDifference;
        if(lengthDifference > 0){
            //if the length change is under 5 m - no fee is charged
            if(lengthDifference >= 5)
                this.price = price + fiveToTen;
            if(lengthDifference >= 10)
                this.price = price + overTen;
        }

    }

    private double findDifference(String newType, String prevType) {

        if (prevType.equalsIgnoreCase("kayak_canoe")) {
            if (newType.equalsIgnoreCase("motorsailer"))
                return 450;
            if (newType.equalsIgnoreCase("sailboat"))
                return 350;
            if (newType.equalsIgnoreCase("other"))
                return 200;
            else
                return 0;
        }
        if (prevType.equalsIgnoreCase("other")) {
            if (newType.equalsIgnoreCase("motorsailer"))
                return 250;
            if (newType.equalsIgnoreCase("sailboat"))
                return 150;
            else
                return 0;
        }
        if (prevType.equalsIgnoreCase("sailboat")) {
            if (newType.equalsIgnoreCase("motorsailer"))
                return 100;
            else
                return 0;
        } else
            return 0;
        }
    }
