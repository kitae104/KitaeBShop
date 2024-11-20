package inhatc.cse.kitaebshop.item.dto;

import inhatc.cse.kitaebshop.item.entity.Item;
import inhatc.cse.kitaebshop.item.entity.ItemImg;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImgDto {

    private Long id;

    private String imgName;         // 이미지 이름

    private String oriImgName;      // 원본 이미지 이름

    private String imgUrl;          // 이미지 경로

    private String repImgYn;

    private static ModelMapper  modelMapper = new ModelMapper();

    public static ItemImgDto of(ItemImg itemImg){
        return modelMapper.map(itemImg, ItemImgDto.class);
    }

}
