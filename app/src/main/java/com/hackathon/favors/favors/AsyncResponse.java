package com.hackathon.favors.favors;

import com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating;

import java.util.List;

/**
 * Created by sreejith on 3/9/16.
 */
public interface AsyncResponse {
    void processResult(String result);

    void processResultList(List<GroceryListWithRating> gListResult);

    void processResultItem(GroceryListWithRating groceryListResult);
}
