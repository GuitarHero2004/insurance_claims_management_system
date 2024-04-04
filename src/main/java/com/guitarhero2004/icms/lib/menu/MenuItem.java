package com.guitarhero2004.icms.lib.menu;

public class MenuItem {
    private final String displayName;
    private final Runnable action;
    private MenuList subMenu;

    public MenuItem(String displayName, Runnable action) {
        this.displayName = displayName;
        this.action = action;
    }

    public MenuItem(String displayName, MenuList subMenu) {
        this.displayName = displayName;
        this.action = () -> {
            try {subMenu.run();} catch (Exception e) {}
        };
        this.subMenu = subMenu;
    }

    public boolean run() throws Exception{
        if (subMenu != null) return subMenu.run();
        action.run();
        return true;
    }

    public void display() {
        System.out.println(displayName);
    }

    public String getDisplayName() {
        if (subMenu != null) {
            return displayName + " >";
        }
        return displayName;
    }

    public MenuList getSubMenu() {
        return subMenu;
    }
}
