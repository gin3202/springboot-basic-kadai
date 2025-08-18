package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaitodo.form.ContactForm;

@Controller
public class ContactFormController {

	// フォーム表示（フラッシュ属性が無ければ新規インスタンスをセット）
	@GetMapping("/contact")
	public String showForm(Model model) {
		if (!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		return "contactFormView";
	}

	// 確認画面表示（POST：バリデーション実行）
	@PostMapping("/contact/confirm")
	public String confirm(
			@Validated ContactForm contactForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model) {

		if (bindingResult.hasErrors()) {
			// リダイレクト先で値とエラーを表示できるようにフラッシュ属性に積む
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			redirectAttributes.addFlashAttribute(
					"org.springframework.validation.BindingResult.contactForm",
					bindingResult);
			return "redirect:/contact";
		}

		// OKの場合は確認画面へ
		model.addAttribute("contactForm", contactForm);
		return "confirmView";
	}

	// 直接GETで確認画面に来た場合はフォームへ
	@GetMapping("/contact/confirm")
	public String confirmGetRedirect() {
		return "redirect:/contact";
	}
}
