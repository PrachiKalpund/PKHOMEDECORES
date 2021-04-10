package com.pkhomedecores.pojo;

public class Tables {

}
/*
 Create table furniture(furnitureId int primary key auto_increment, furnitureName varchar(30), furnitureCat varchar(20), furniturePrice double(6,2));
Query OK, 0 rows affected (1.09 sec)

mysql> create table customer(custId int primary key auto_increment,custName varchar(30),custEmail varchar(40), custPass varchar(20),custContact varchar(10), custAddress varchar(30));
Query OK, 0 rows affected (0.56 sec)

mysql> create table Cart(cartId int primary key auto_increment, custEmail varchar(40), furnitureId int, quantity int);
Query OK, 0 rows affected (0.47 sec)

mysql> create table orders(orderId int primary key auto_increment, custEmail varchar(40),orderDate date, bill double(10,2));
Query OK, 0 rows affected (0.56 sec)

 */
