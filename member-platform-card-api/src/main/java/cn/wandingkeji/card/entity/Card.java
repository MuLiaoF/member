package cn.wandingkeji.card.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("tbl_card")
@Data
public class Card  {

    private Integer id;
    private String name;
}
