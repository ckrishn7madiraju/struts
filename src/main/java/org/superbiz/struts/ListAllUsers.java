package org.superbiz.struts;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAllUsers {

    private int id;
    private String errorMessage;
    private List<User> users;

    private final UserService userService;

    public ListAllUsers (UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {

        try {
            this.users = userService.findAll();
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            return "failure";
        }

        return "success";
    }
}
