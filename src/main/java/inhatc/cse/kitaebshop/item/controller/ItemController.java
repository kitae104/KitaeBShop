package inhatc.cse.kitaebshop.item.controller;

import inhatc.cse.kitaebshop.item.dto.ItemDataDto;
import inhatc.cse.kitaebshop.item.dto.ItemDto;
import inhatc.cse.kitaebshop.item.dto.ItemFormDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @GetMapping("/admin/item/add")
    public String itemAdd(Model model){
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
