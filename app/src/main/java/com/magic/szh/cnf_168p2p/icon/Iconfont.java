package com.magic.szh.cnf_168p2p.icon;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;

import com.mikepenz.iconics.typeface.GenericFont;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.icon
 * file: Iconfont
 * author: admin
 * date: 2018/2/13
 * description:
 */

public class Iconfont implements ITypeface {

    private static final String TTF_FILE = "iconfont.ttf";

    public enum Icon implements IIcon {
        alipay('\ue702'),  // 支付宝
        wechat('\ue7e5'),  // 微信
        weibo('\ue6b2');   // 微博

        private final char character;
        private static ITypeface typeface;

        Icon(char character) {
            this.character = character;
        }

        @Override
        public String getFormattedName() {
            return "{" + name() + "}";
        }

        @Override
        public String getName() {
            return name();
        }

        @Override
        public char getCharacter() {
            return character;
        }

        @Override
        public ITypeface getTypeface() {
            if (typeface == null)
                typeface = new Iconfont();
            return typeface;
        }
    }

    private static HashMap<String, Character> mCharacters;

    private static Typeface typeface = null;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mCharacters == null) {
            HashMap<String, Character> aChars = new HashMap<>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mCharacters = aChars;
        }
        return mCharacters;
    }

    @Override
    public String getMappingPrefix() {
        return "icc";
    }

    @Override
    public String getFontName() {
        return "";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public int getIconCount() {
        return mCharacters.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<>();
        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override
    public String getAuthor() {
        return "magic_su";
    }

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getLicense() {
        return "";
    }

    @Override
    public String getLicenseUrl() {
        return "";
    }

    @Override
    public Typeface getTypeface(Context ctx) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(ctx.getAssets(),"fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }
}
