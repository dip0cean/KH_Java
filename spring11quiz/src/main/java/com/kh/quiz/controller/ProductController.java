package com.kh.quiz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.quiz.entity.ProductDTO;
import com.kh.quiz.repository.ProductDAO;

@Controller
@RequestMapping("/item")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	// 메인 페이지
	@RequestMapping("")
	public String home() {
		return "item/home";
	}

	// 상품 등록 페이지
	@GetMapping("/add")
	public String add() {
		return "item/add";
	}

	// 상품 등록 메소드
	@PostMapping("/add")
	public String add(@ModelAttribute ProductDTO productDTO) {
		// 들어온 productDTO 로 상품 등록
		boolean result = productDAO.regist(productDTO);

		if (result) {
			return "redirect:list";
		}

		return "redirect:add?error";
	}

	// 상품 수정 페이지
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam long no) {
		ProductDTO product = productDAO.detail(no);

		model.addAttribute("product", product);

		return "item/edit";
	}

	// 상품 수정 메소드
	@PostMapping("/edit")
	public String edit(@ModelAttribute ProductDTO productDTO) {
		productDAO.edit(productDTO);

		return "redirect:list";
	}

	// 상품 삭제 페이지
	@GetMapping("/delete")
	public String delete(Model model, @RequestParam long no) {
		ProductDTO productDTO = productDAO.detail(no);
		model.addAttribute("product", productDTO);

		return "item/delete";
	}

	// 상품 삭제 메소드
	@PostMapping("/delete")
	public String delete(@ModelAttribute ProductDTO productDTO, @RequestParam String check) {

		System.out.println("check 의 상태가..? " + check);
		System.out.println("product 상태가..? " + productDTO);

		if (check.equals("true")) {
			productDAO.delete(productDTO);
		}

		return "redirect:list";
	}

	// 상품 리스트 + 검색
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(required = false) String type,
			@RequestParam(required = false) String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("keyword", keyword);

		List<ProductDTO> list = productDAO.listSearch(map);
		model.addAttribute("list", list);

		return "item/list";
	}
}
