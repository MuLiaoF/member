package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.Card;
import cn.wandingkeji.mapper.card.CardMapper;
import cn.wandingkeji.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public Card getCard(String id) {
        return cardMapper.selectById(id);
    }
}
