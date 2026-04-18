package stsmod.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import stsmod.STSCardMod;

import java.util.HashMap;

public class TextureLoader {
    private static final HashMap<String, Texture> textures = new HashMap<>();

    public static Texture getTexture(String filePath) {
        return getTexture(filePath, true);
    }

    public static Texture getTexture(String filePath, boolean linear) {
        if (textures.get(filePath) == null) {
            try {
                loadTexture(filePath, linear);
            } catch (Exception e) {
                STSCardMod.logger.info("Failed to load texture: " + filePath);
                return null;
            }
        }
        return textures.get(filePath);
    }

    private static void loadTexture(String filePath, boolean linear) {
        FileHandle fileHandle = Gdx.files.internal(filePath);
        Texture texture = new Texture(fileHandle);
        if (linear) {
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        } else {
            texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        }
        textures.put(filePath, texture);
    }

    public static String getCardTextureString(String cardName, com.megacrit.cardcrawl.cards.AbstractCard.CardType cardType) {
        String typePath;
        switch (cardType) {
            case ATTACK:
                typePath = "cards/attack/";
                break;
            case SKILL:
                typePath = "cards/skill/";
                break;
            case POWER:
                typePath = "cards/power/";
                break;
            default:
                typePath = "cards/attack/";
                break;
        }
        return STSCardMod.imagePath(typePath + cardName + ".png");
    }
}