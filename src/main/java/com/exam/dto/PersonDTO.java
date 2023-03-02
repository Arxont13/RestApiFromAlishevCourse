package com.exam.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonDTO {

    @NotEmpty(message="Не заполнено имя")
    @Size(min = 2, max = 30, message = "Имя должно быть длиной от 2 до 30 символов")
    private String name;

    @Min(value = 0, message = "Возраст должен быть больше чем 0")
    private int age;

    @Email
    @NotEmpty(message = "Почта не должна быть пустой")
    private String email;
}
