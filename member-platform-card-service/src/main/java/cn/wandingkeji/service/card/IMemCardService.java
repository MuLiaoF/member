package cn.wandingkeji.service.card;


import java.math.BigDecimal;
import java.util.Map;


public interface IMemCardService {

    Map<String, Object> judgeUpgradeMemCard(int mid, int member_id, BigDecimal amount) ;

    void updateMemLevelByAmtBalance(BigDecimal bonus, int memberId, int mid, String currentSort, String card_barcode);

    void updataMemberCardInfo(String card_barcode, int mid, String currentLevel, String card_id, String background_pic_url);

}
