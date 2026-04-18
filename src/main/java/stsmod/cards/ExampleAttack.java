package stsmod.cards;

import stsmod.STSCardMod;
import stsmod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ExampleAttack extends BaseCard {
    
    public static final String ID = makeID("ExampleAttack");
    private static final CardStats info = new CardStats(
        CardColor.RED,       // 铁甲战士红色
        CardType.ATTACK,     // 攻击卡
        CardRarity.BASIC,    // 基础卡
        CardTarget.ENEMY,    // 目标敌人
        1                    // 花费 1 能量
    );

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    public ExampleAttack() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(
            m,
            new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL),
            AbstractGameAction.AttackEffect.SLASH_DIAGONAL
        ));
    }
}