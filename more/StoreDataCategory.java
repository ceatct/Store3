package com.example.store;

public class StoreDataCategory {

    Source source = null;

    Integer parent = Integer.valueOf("");
    Integer depth = Integer.valueOf("");

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
