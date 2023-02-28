package com.exam.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
@Entity
@Table(name="Person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotEmpty(message="Не заполнено имя")
    @Size(min = 2, max = 30, message = "Имя должно быть длиной от 2 до 30 символов")
    private String name;

    @Column(name="age")
    @Min(value = 0, message = "Возраст должен быть больше чем 0")
    private int age;

    @Column(name="email")
    @Email
    @NotEmpty(message = "Почта не должна быть пустой")
    private String email;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

}
