package com.inveitix.mindler;

public class DataTransferObject {

    private String queryType = "";
    private String data = "";
    private String clientUID = "";

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getClientUID() {
        return clientUID;
    }

    public void setClientUID(String clientUID) {
        this.clientUID = clientUID;
    }

}
