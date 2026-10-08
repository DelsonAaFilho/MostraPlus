package com.example.a3work.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@TAG is used to group the API endpoints related to user management under the "Users" tag in the Swagger UI.
 */
@Tag(name="Users", description = "API for managing users")
@RestController
@RequestMapping("api/v1/users")
public class usersController {




}
