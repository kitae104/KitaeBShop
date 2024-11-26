package inhatc.cse.kitaebshop.item.controller;

import inhatc.cse.kitaebshop.item.dto.ItemDataDto;
import inhatc.cse.kitaebshop.item.dto.ItemDto;
import inhatc.cse.kitaebshop.item.dto.ItemFormDto;
import inhatc.cse.kitaebshop.item.service.ItemService;
import inhatc.cse.kitaebshop.member.dto.MemberDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/admin/item/add")
    public String itemAdd(@Valid ItemFormDto itemFormDto,
                          BindingResult bindingResult,
                          Model model,
                          @RequestParam("itemImgFile")List<MultipartFile> itemImgList){

        if(bindingResult.hasErrors()){
            return "item/add";
        }
        if(itemImgList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입니다.");
            return "item/add";
        }

        try {
            itemService.saveItem(itemFormDto, itemImgList);
        } catch (IOException e) {
            model.addAttribute("errorMessage", "파일 저장에 실패했습니다.");
            return "item/add";
        }
        return "redirect:/";
    }


    @GetMapping("/admin/item/add")
    public String itemAddForm(Model model){
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "item/add";
    }

    @GetMapping("/admin/items")
    public String itemList(){
        return "item/list";
    }



    @GetMapping("/item/thymeleaf1")
    public String thymeleaf1(Model model){
        ItemDto itemDto = ItemDto.builder()
                .id(1L)
                .itemNm("111111")
                .itemDetail("가을에만 파는 가디건")
                .price(20000)
                .stockNumber(200)
                .build();

        model.addAttribute("itemDto", itemDto);

        return "item/thymeleaf1";
    }

    @GetMapping("/item/thymeleaf2")
    public String thymeleaf2(ItemDataDto itemDataDto,
                             Model model){
        System.out.println("=============" + itemDataDto);

        model.addAttribute("itemDataDto", itemDataDto);

        return "item/thymeleaf2";
    }
}
