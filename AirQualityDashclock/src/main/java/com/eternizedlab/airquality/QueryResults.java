package com.eternizedlab.airquality;


import java.util.Date;
import java.util.List;

class QueryResults {
    private List<AQIData> aqiDataList;
    private Integer overallAQI;
    private Integer overallAQIInUS;
    private Date lastModify;
    private Date lastQuery;

    public List<AQIData> getAqiDataList() {
        return aqiDataList;
    }

    public void setAqiDataList(List<AQIData> aqiDataList) {
        this.aqiDataList = aqiDataList;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public Date getLastQuery() {
        return lastQuery;
    }

    public void setLastQuery(Date lastQuery) {
        this.lastQuery = lastQuery;
    }

    public Integer getOverallAQI() {
        return overallAQI;
    }

    public void setOverallAQI(Integer overallAQI) {
        this.overallAQI = overallAQI;
    }

    public Integer getOverallAQIInUS() {
        return overallAQIInUS;
    }

    public void setOverallAQIInUS(Integer overallAQIInUS) {
        this.overallAQIInUS = overallAQIInUS;
    }
}
