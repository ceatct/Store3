package com.example.store;

import java.lang.reflect.Array;

public class ProductTODO {

    private Integer nid;
    private Array nids;
    private Integer category;
    private Integer action;
    private String text;

    public Integer getNid(){return nid;}
    public void setNid (Integer nid){this.nid = nid;}

    public Array getNids(){return nids;}
    public void setNids (Array nids){this.nids = nids;}

    public Integer getCategory(){return category;}
    public void setCategory (Integer category){this.category = category;}

    public Integer getAction(){return action;}
    public void setAction (Integer action){this.action = action;}

    public String getText(){return text;}
    public void setText (String text){this.text = text;}
}
