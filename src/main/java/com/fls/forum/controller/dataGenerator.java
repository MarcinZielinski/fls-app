package com.fls.forum.controller;

import com.fls.forum.model.Section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataGenerator {

    private List<Section> sections;

    public dataGenerator(){
        sections = new ArrayList<>();
        fillWithSections();
    }

    private void fillWithSections(){
        sections.add(new Section(1, "Java", "Programowanie w języku Java"));
        sections.add(new Section(2, "Humor", "Napisz coś śmiesznego"));
        sections.add(new Section(3, "Koło", "BIT, AGLO, AI i inne"));

    }

    public List<Section> getSections(){
        return sections;
    }

}
