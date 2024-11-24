package com.example.exam2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    @NotEmpty(message = "id should not be empty")
    @Size(min = 4,max = 10,message = "id should have more then 3 numbers max to 10 ")
    private String ID;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 4,message = "name should be more then 3 character")
    private String name;

    @NotNull(message = "number of pages should not be empty")
   @Min(value = 10,message = "should be longer then 10")
    private int numberOfPages;

    @NotNull(message = "price should not ve null")
    @Min(value = 20,message = "price should be more then 20 ")
    @Max(value = 100,message = "price should be lower then 100")
    private int price;

    @NotEmpty(message = "category should not be empty")
    @Pattern(regexp = "^(novel|academic)$", message = "category should be novel or academic ")
    private String category;


    private boolean isAvailable=false;
}
