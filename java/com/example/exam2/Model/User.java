package com.example.exam2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "id should not be empty")
    @Size(min = 4,max = 10,message = "id should have more then 3 numbers max to 10 ")
    private String ID;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 4,message = "name should be more then 3 character")
    private String name;

   @NotNull(message = "age should not be null")
   @Min(value = 20,message = "age should be above 20")
   private int age;

   @NotNull(message = "massage should not be null")
   @Positive
   private  int balance;
    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(customer|libraian)$", message = "category should be customer or libraian ")
   private String role;

}
