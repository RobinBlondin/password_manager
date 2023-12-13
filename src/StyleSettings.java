import java.awt.*;

public class StyleSettings {
    private static StyleSettings instance;

    private final Font bigFont;
    private final Font mediumFont;
    private final Font smallFont;
    private final Color backgroundColor_LIGHT;
    private final Color backgroundColor_DARK;
    private final Color backgroundColor_SELECTED;
    private final Color textColor_BLACK;
    private final Color textColor_WHITE;
    private final Color textColor_SELECTED;
    private final Color textColor_DARK;
    private final Color textColor_LIGHT;

    public StyleSettings() {
        bigFont = new Font("Sans Serif", Font.PLAIN, 35);
        mediumFont = new Font("Sans Serif", Font.PLAIN, 25);
        smallFont = new Font("Sans Serif", Font.PLAIN, 18);
        backgroundColor_LIGHT = new Color(216, 230, 232);
        backgroundColor_DARK = new Color(12, 100,118);
        backgroundColor_SELECTED = new Color(206, 226, 228);
        textColor_BLACK = new Color(0, 0, 0);
        textColor_WHITE = new Color(255, 255, 255);
        textColor_SELECTED = new Color(38, 98, 110);
        textColor_DARK = new Color(26, 63, 59);
        textColor_LIGHT = new Color(157, 172, 174);
    }
    public static StyleSettings getInstance() {
        if (instance == null) {
            instance = new StyleSettings();
        }
        return instance;
    }

    public Font getBigFont() {
        return bigFont;
    }

    public Font getMediumFont() {
        return mediumFont;
    }

    public Font getSmallFont() {
        return smallFont;
    }

    public Color getBackgroundColor_LIGHT() {
        return backgroundColor_LIGHT;
    }

    public Color getBackgroundColor_DARK() {
        return backgroundColor_DARK;
    }

    public Color getBackgroundColor_SELECTED() {
        return backgroundColor_SELECTED;
    }

    public Color getTextColor_BLACK() {
        return textColor_BLACK;
    }

    public Color getTextColor_WHITE() {
        return textColor_WHITE;
    }

    public Color getTextColor_SELECTED() {
        return textColor_SELECTED;
    }

    public Color getTextColor_DARK() {
        return textColor_DARK;
    }

    public Color getTextColor_LIGHT() {
        return textColor_LIGHT;
    }
}
