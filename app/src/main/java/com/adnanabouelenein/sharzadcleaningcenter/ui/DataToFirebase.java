package com.adnanabouelenein.sharzadcleaningcenter.ui;

public class DataToFirebase {
    private String name, phoneNumber, email, password, confirmPassword, carModel;

    public DataToFirebase(String name, String phoneNumber, String email, String password, String confirmPassword, String carModel) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.carModel = carModel;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCarModel() {
        return carModel;
    }
}

