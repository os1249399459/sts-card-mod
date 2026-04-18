package stsmod;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import stsmod.cards.ExampleAttack;
import stsmod.util.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class STSCardMod implements 
        EditStringsSubscriber,
        EditCardsSubscriber,
        PostInitializeSubscriber {

    public static final String modID = "stsmod";
    public static final Logger logger = LogManager.getLogger(modID);

    // 资源路径
    private static final String resourcesFolder = "stsmod";

    // 生成 ID
    public static String makeID(String id) {
        return modID + ":" + id;
    }

    // 图片路径
    public static String imagePath(String path) {
        return resourcesFolder + "/images/" + path;
    }

    // 语言文件路径
    public static String localizationPath(String lang, String file) {
        return resourcesFolder + "/localization/" + lang + "/" + file;
    }

    // SpireInitializer 会自动调用这个方法（类上的注解）
    public static void initialize() {
        new STSCardMod();
    }

    public STSCardMod() {
        BaseMod.subscribe(this);
        logger.info(modID + " subscribed to BaseMod.");
    }

    @Override
    public void receivePostInitialize() {
        // 加载 mod badge 图片
        Texture badgeTexture = TextureLoader.getTexture(imagePath("badge.png"));
        BaseMod.registerModBadge(badgeTexture, "STS Card Mod", "You", "A custom card mod", null);
    }

    @Override
    public void receiveEditStrings() {
        // 加载本地化
        String lang = Settings.language.name().toLowerCase();
        
        // 默认英语
        BaseMod.loadCustomStringsFile(CardStrings.class, localizationPath("eng", "cards.json"));
        
        // 中文支持
        if ("zhs".equals(lang)) {
            BaseMod.loadCustomStringsFile(CardStrings.class, localizationPath("zhs", "cards.json"));
        }
    }

    @Override
    public void receiveEditCards() {
        // 注册卡牌
        BaseMod.addCard(new ExampleAttack());
    }
}