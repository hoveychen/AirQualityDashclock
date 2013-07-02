package com.eternizedlab.airquality;

class AQIData {
    private String monitorName;
    private Integer AQI;
    private Integer pm25;
    private Integer pm10;

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public Integer getAQI() {
        return AQI;
    }

    public void setAQI(Integer AQI) {
        this.AQI = AQI;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }
}