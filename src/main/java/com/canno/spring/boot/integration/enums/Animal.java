package com.canno.spring.boot.integration.enums;

public enum  Animal {
    DOG(2,"狗");
    int value;
    String desc;
    private Animal(int value, String desc){
        this.value = value;
        this.desc = desc;
    }


    public static void main(String[] args) {
        System.out.println(Animal.DOG.value);
        System.out.println(Animal.DOG.desc);
    }
}
