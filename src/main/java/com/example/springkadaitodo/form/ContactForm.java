package com.example.springkadaitodo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactForm {

    @NotBlank(message = "お名前を入力してください。")
    private String name;

    @NotBlank(message = "メールアドレスは必須です。")
    @Email(message = "メールアドレスの入力形式が正しくありません。")
    private String email;

    @NotBlank(message = "お問い合わせ内容を入力してください。")
    private String message;

    // --- getter / setter ---
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
