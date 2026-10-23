package com.nivex.lagtester;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private LinearLayout root;
    private TextView status;
    private int red = Color.rgb(255, 55, 72);
    private int muted = Color.rgb(180, 185, 198);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(12, 12, 18));
        getWindow().setNavigationBarColor(Color.rgb(12, 12, 18));
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.rgb(12, 12, 18));
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(24), dp(20), dp(28));
        scroll.addView(root);
        setContentView(scroll);

        TextView brand = text("NIVEX", 16, red, true);
        brand.setLetterSpacing(0.18f);
        root.addView(brand);
        TextView title = text("LAG TESTER", 30, Color.WHITE, true);
        title.setPadding(0, dp(4), 0, 0);
        root.addView(title);
        TextView subtitle = text("VIP STYLE • VERSION 1.0", 12, muted, true);
        subtitle.setPadding(0, dp(4), 0, dp(18));
        root.addView(subtitle);

        LinearLayout hero = panel();
        root.addView(hero);
        TextView badge = text("SIMULATION MODE", 11, red, true);
        hero.addView(badge);
        TextView heroTitle = text("TEST THE CLAIMS.\nNOT YOUR MAIN ID.", 22, Color.WHITE, true);
        heroTitle.setPadding(0, dp(10), 0, dp(8));
        hero.addView(heroTitle);
        TextView heroBody = text("This is a safe visual demo. It does not connect to or modify Free Fire / Free Fire MAX.", 14, muted, false);
        heroBody.setLineSpacing(dp(3), 1f);
        hero.addView(heroBody);

        TextView features = text("FEATURE DEMOS", 14, Color.WHITE, true);
        features.setPadding(0, dp(24), 0, dp(10));
        root.addView(features);
        addButton("❄  FREEZE DEMO", "Shows a temporary freeze-style screen effect.", "Freeze demo ran locally. No game was changed.");
        addButton("👻  GHOST DEMO", "Shows a visual ghost-style overlay.", "Ghost visual demo ran locally. No game was changed.");
        addButton("🎯  TELEKILL DEMO", "Shows a mock feature card only; no targeting or game interaction.", "Telekill is a mock demo only. No game interaction occurred.");

        TextView device = text("DEVICE CHECK", 14, Color.WHITE, true);
        device.setPadding(0, dp(24), 0, dp(10));
        root.addView(device);
        addButton("📊  CHECK BASIC DEVICE INFO", "Display a simple local status message.", "Device status: app running normally. Actual FPS/ping are not measured by this demo.");

        status = text("STATUS: READY", 13, Color.rgb(120, 255, 170), true);
        status.setPadding(dp(14), dp(14), dp(14), dp(14));
        status.setBackground(round(Color.rgb(22, 35, 30), dp(12)));
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.topMargin = dp(18);
        root.addView(status, sp);

        TextView disclaimer = text("IMPORTANT: Demo only. No cheats, anti-ban, freeze, ghost, or telekill functionality is applied to Free Fire. Do not trust third-party app claims without independent checks.", 12, muted, false);
        disclaimer.setLineSpacing(dp(3), 1f);
        disclaimer.setPadding(dp(2), dp(18), dp(2), 0);
        root.addView(disclaimer);
        TextView footer = text("TEST • PLAY • EXPOSE  |  NIVEX GAMING", 11, red, true);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(24), 0, 0);
        root.addView(footer);
    }

    private void addButton(String title, String desc, String result) {
        LinearLayout card = panel();
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(-1, -2);
        cp.topMargin = dp(10);
        root.addView(card, cp);
        TextView t = text(title, 16, Color.WHITE, true);
        card.addView(t);
        TextView d = text(desc, 12, muted, false);
        d.setPadding(0, dp(7), 0, dp(12));
        card.addView(d);
        TextView button = text("RUN DEMO  →", 13, Color.WHITE, true);
        button.setGravity(Gravity.CENTER);
        button.setPadding(dp(12), dp(12), dp(12), dp(12));
        button.setBackground(round(red, dp(10)));
        card.addView(button);
        button.setOnClickListener(v -> {
            status.setText("STATUS: " + result);
            status.setTextColor(Color.rgb(255, 205, 120));
        });
    }

    private LinearLayout panel() {
        LinearLayout p = new LinearLayout(this);
        p.setOrientation(LinearLayout.VERTICAL);
        p.setPadding(dp(16), dp(16), dp(16), dp(16));
        p.setBackground(round(Color.rgb(25, 25, 34), dp(16)));
        return p;
    }
    private TextView text(String s, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(size); t.setTextColor(color);
        t.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL);
        return t;
    }
    private GradientDrawable round(int color, int radius) {
        GradientDrawable d = new GradientDrawable(); d.setColor(color); d.setCornerRadius(radius); return d;
    }
    private int dp(int v) { return (int)(v * getResources().getDisplayMetrics().density + 0.5f); }
}
