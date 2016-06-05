package com.inveitix.mindler;

import com.inveitix.mindler.cmn.City;

import java.util.ArrayList;
import java.util.List;

public interface WebDataListener {
    void cityListReceived(ArrayList<City> cities);
}
