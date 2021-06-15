package com.example.movielist.model;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {


    public List<Search> Search;
    public String totalResults;
    public String Response;


    public List<com.example.movielist.model.Search> getSearch() {
        return Search;
    }

    public void setSearch(List<com.example.movielist.model.Search> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
