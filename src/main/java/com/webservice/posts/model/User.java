package com.webservice.posts.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@ApiModel(description = "User documentation details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{user.validation.name.empty}")
    @Size(min = 3, message = "{user.validation.name.size}")
    @ApiModelProperty(notes = "Name must not be null and contains at least 3 characters.")
    private String name;

    @NotNull(message = "{user.validation.birthDate.empty}")
    @Past(message = "{user.validation.birthDate.past}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Birthday must not be null and must be greater than today's date")
    private LocalDate birthDate;

    public User() {}

    public User(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
