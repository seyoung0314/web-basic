package org.example.web_basic.chap02;

import java.util.ArrayList;
import java.util.List;

public class DancerList {
    private static List<Dancer> dancerList = new ArrayList<>();

    //댄서 목록을 갖다주는 기능


    public DancerList() {
    }

    public static List<Dancer> getDancerList() {
        return dancerList;
    }

    public static void addDancer(Dancer dancer){
        dancerList.add(dancer);
    }
}
