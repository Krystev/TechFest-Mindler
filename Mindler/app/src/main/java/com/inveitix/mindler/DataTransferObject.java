package com.inveitix.mindler;

public class DataTransferObject {

    private String QueryType = "";
    private String Data = "";
    private String ClientUID = "";

    public String getQueryType() {
        return QueryType;
    }

    public void setQueryType(String queryType) {
        this.QueryType = queryType;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public String getClientUID() {
        return ClientUID;
    }

    public void setClientUID(String clientUID) {
        this.ClientUID = clientUID;
    }

}
