package net.bruhitsalex.branchlockdesktop.ui.settings;

import net.bruhitsalex.branchlockdesktop.ui.settings.configurations.ConfigIOPane;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class ConfigPane extends JPanel {

    private JScrollPane scrollPane;
    private ConfigIOPane configIOPane;

    public ConfigPane() {
        initComponents();
        initLayouts();
    }

    private void initComponents() {
        JEditorPane editorPane = new JEditorPane();
        scrollPane = new JScrollPane(editorPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        editorPane.setEditable(false);
        editorPane.setEditorKit(new StyledEditorKit());
        editorPane.setText("# Default themes (dark & light) will be refreshed if modified on each launch\n" +
                "# if you wanna make a new theme, copy and paste this file and rename it to your\n" +
                "# theme name, then edit\n" +
                "\n" +
                "# Colours - always start with the prefix \"color(\" and ends with \")\".\n" +
                "# You must contain 3 (RGB) or 4 (RGBA) digits ranging between 0-255\n" +
                "\n" +
                "# Shapes - always start with prefix \"shape(\" and end with \")\"\n" +
                "# Must be one of three: RECTANGLE, ROUNDED_RECTANGLE, CIRCLE\n" +
                "# Note that rectangle will render the fastest, and the other two may slightly decrease performance, especially circle.\n" +
                "\n" +
                "# Don't change this unless you have updated this to the newest version\n" +
                "theme-version: \"1.0\"\n" +
                "\n" +
                "name: \"Monokai Pro\"\n" +
                "\n" +
                "general:\n" +
                "  force-minecraft-font: false\n" +
                "  rounded-rectangle-anti-alias: true # looks good, kinda heavy on rendering times\n" +
                "\n" +
                "hud:\n" +
                "  shape: \"shape(RECTANGLE)\"\n" +
                "  colour:\n" +
                "    background: \"color(0, 0, 0, 62)\"\n" +
                "    text-primary-on: \"color(119, 222, 233)\"\n" +
                "    text-normal: \"color(169, 140, 246)\"\n" +
                "    text-primary-off: \"color(228, 78, 112)\"\n" +
                "\n" +
                "window:\n" +
                "  colour:\n" +
                "    background: \"color(26, 25, 27)\"\n" +
                "  shape: \"shape(RECTANGLE)\"\n" +
                "\n" +
                "panels:\n" +
                "  colour:\n" +
                "    background: \"color(33, 31, 34)\"\n" +
                "    scroller: \"color(209, 206, 94, 50)\"\n" +
                "    scroller-hover: \"color(209, 206, 94, 100)\"\n" +
                "  shape: \"shape(RECTANGLE)\"\n" +
                "\n" +
                "menu-selection:\n" +
                "  colour:\n" +
                "    background: \"color(33, 31, 34)\"\n" +
                "    not-selected-icon: \"color(128, 128, 128)\"\n" +
                "    selected-icon: \"color(167, 237, 118)\"\n" +
                "    hover-icon: \"color(147, 217, 98, 50)\"\n" +
                "  shape: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "\n" +
                "text:\n" +
                "  colour:\n" +
                "    standard: \"color(180, 180, 180)\"\n" +
                "    subtitle: \"color(255, 91, 123)\"\n" +
                "    title: \"color(228, 133, 97)\"\n" +
                "    categories-title: \"color(167, 237, 118)\"\n" +
                "    selected-category: \"color(167, 237, 118)\"\n" +
                "    hover-category: \"color(102, 222, 255)\"\n" +
                "  misc:\n" +
                "    disable-shadows: false # recommended on for light theme, they look weird\n" +
                "\n" +
                "components:\n" +
                "  general:\n" +
                "    colour:\n" +
                "      background: \"color(44, 41, 45)\"\n" +
                "      background-hover: \"color(62, 59, 63)\"\n" +
                "      background-hover-2: \"color(52, 49, 53)\"\n" +
                "    shape: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "  text-enter:\n" +
                "    colour:\n" +
                "      valid: \"color(176, 219, 92)\"\n" +
                "      invalid: \"color(150, 50, 50)\"\n" +
                "      unfocused: \"color(26, 25, 27)\"\n" +
                "      unfocused-hover: \"color(37, 37, 37)\"\n" +
                "    shape: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "  toggle:\n" +
                "    colour:\n" +
                "      enabled: \"color(220, 211, 80)\"\n" +
                "      enabled-hover: \"color(235, 225, 85)\"\n" +
                "      disabled: \"color(165, 161, 255)\"\n" +
                "      disabled-hover: \"color(180, 177, 255)\"\n" +
                "      icon: \"color(255, 255, 255, 255)\"\n" +
                "    shapes:\n" +
                "      bar: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "      icon: \"shape(CIRCLE)\"\n" +
                "  slider:\n" +
                "    colour:\n" +
                "      bar: \"color(165, 161, 255)\"\n" +
                "      bar-hover: \"color(180, 177, 255)\"\n" +
                "      icon: \"color(191, 191, 191, 220)\"\n" +
                "    shapes:\n" +
                "      bar: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "      icon: \"shape(CIRCLE)\"\n" +
                "  selection:\n" +
                "    colour:\n" +
                "      normal: \"color(34, 34, 34)\"\n" +
                "      hover: \"color(37, 37, 37)\"\n" +
                "    shape: \"shape(ROUNDED_RECTANGLE)\"\n" +
                "  safety-slider:\n" +
                "    colour:\n" +
                "      safe: \"color(50, 130, 50)\"\n" +
                "      warning: \"color(130, 119, 50)\"\n" +
                "      danger: \"color(150, 50, 50)\"\n" +
                "  banwave:\n" +
                "    colour:\n" +
                "      safe: \"color(50, 130, 50)\"\n" +
                "      warning: \"color(130, 119, 50)\"\n" +
                "      danger: \"color(150, 50, 50)\"\n" +
                "  async-image:\n" +
                "    colour:\n" +
                "      loading: \"color(150, 50, 50)\"\n" +
                "\n" +
                "# animations\n" +
                "# paddings\n" +
                "# window size");
        configIOPane = new ConfigIOPane();
    }

    private void initLayouts() {
        GroupLayout layout = new GroupLayout(this);

        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(scrollPane)
                        .addComponent(configIOPane)
        );

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addGap(20, 20, 20)
                        .addComponent(configIOPane)
        );

        setLayout(layout);
    }

}
