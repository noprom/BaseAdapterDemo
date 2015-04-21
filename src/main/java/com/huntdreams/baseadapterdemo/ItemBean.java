package com.huntdreams.baseadapterdemo;

/**
 * Created by noprom on 2015/4/22.
 */
public class ItemBean {
    public int itemImageResId;
    public String itemTitle;
    public String itemContent;

    public ItemBean(int itemImageResId, String itemContent, String itemTitle) {
        this.itemImageResId = itemImageResId;
        this.itemContent = itemContent;
        this.itemTitle = itemTitle;
    }
}
