package com.example.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryTODO {

    private Integer parent;
    private Integer depth;

    //public static Integer getParent(){return parent;}
    public void setParent (Integer parent){this.parent = parent;}

    public Integer getDepth(){return depth;}
    public void setDepth (Integer depth){this.depth = depth;}

}