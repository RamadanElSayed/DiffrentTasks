package mobile.s.todogoals.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontHelper {

    public static final String CAIRO_FONT = "Cairo.ttf";
    public static final String ANTIC_FONT = "Antic-Regular.ttf";

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
