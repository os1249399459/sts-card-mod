package stsmod.cards;

import basemod.abstracts.CustomCard;
import stsmod.STSCardMod;
import stsmod.util.CardStats;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import static stsmod.util.TextureLoader.getCardTextureString;

public abstract class BaseCard extends CustomCard {
    
    protected CardStrings cardStrings;
    protected boolean upgradesDescription;
    
    protected int baseCost;
    protected boolean upgradeCost;
    protected int costUpgrade;
    
    protected boolean upgradeDamage;
    protected boolean upgradeBlock;
    protected boolean upgradeMagic;
    
    protected int damageUpgrade;
    protected int blockUpgrade;
    protected int magicUpgrade;

    public BaseCard(String ID, CardStats info) {
        this(ID, info, getCardTextureString(removePrefix(ID), info.cardType));
    }

    public BaseCard(String ID, CardStats info, String cardImage) {
        super(ID, CardCrawlGame.languagePack.getCardStrings(ID).NAME, cardImage,
              info.baseCost, CardCrawlGame.languagePack.getCardStrings(ID).DESCRIPTION,
              info.cardType, info.cardColor, info.cardRarity, info.cardTarget);
        
        this.cardStrings = CardCrawlGame.languagePack.getCardStrings(cardID);
        this.originalName = cardStrings.NAME;
        
        this.baseCost = info.baseCost;
        this.upgradesDescription = cardStrings.UPGRADE_DESCRIPTION != null;
        
        this.upgradeCost = false;
        this.upgradeDamage = false;
        this.upgradeBlock = false;
        this.upgradeMagic = false;
        
        this.costUpgrade = info.baseCost;
        this.damageUpgrade = 0;
        this.blockUpgrade = 0;
        this.magicUpgrade = 0;
    }

    protected static String makeID(String name) {
        return STSCardMod.makeID(name);
    }

    private static String removePrefix(String ID) {
        return ID.substring(ID.indexOf(":") + 1);
    }

    protected void setDamage(int damage) {
        this.setDamage(damage, 0);
    }

    protected void setDamage(int damage, int damageUpgrade) {
        this.baseDamage = this.damage = damage;
        if (damageUpgrade != 0) {
            this.upgradeDamage = true;
            this.damageUpgrade = damageUpgrade;
        }
    }

    protected void setBlock(int block) {
        this.setBlock(block, 0);
    }

    protected void setBlock(int block, int blockUpgrade) {
        this.baseBlock = this.block = block;
        if (blockUpgrade != 0) {
            this.upgradeBlock = true;
            this.blockUpgrade = blockUpgrade;
        }
    }

    protected void setMagic(int magic) {
        this.setMagic(magic, 0);
    }

    protected void setMagic(int magic, int magicUpgrade) {
        this.baseMagicNumber = this.magicNumber = magic;
        if (magicUpgrade != 0) {
            this.upgradeMagic = true;
            this.magicUpgrade = magicUpgrade;
        }
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            
            if (this.upgradeDamage) {
                this.upgradeDamage(this.damageUpgrade);
            }
            if (this.upgradeBlock) {
                this.upgradeBlock(this.blockUpgrade);
            }
            if (this.upgradeMagic) {
                this.upgradeMagicNumber(this.magicUpgrade);
            }
            if (this.upgradeCost) {
                this.upgradeBaseCost(this.costUpgrade);
            }
            
            if (this.upgradesDescription && cardStrings.UPGRADE_DESCRIPTION != null) {
                this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
                this.initializeDescription();
            }
        }
    }
}