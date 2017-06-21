
package com.example.vrungel.litera.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LibInfo {

    @SerializedName("add_date")
    @Expose
    private Integer addDate;
    @SerializedName("last_chr_count")
    @Expose
    private Integer lastChrCount;
    @SerializedName("type")
    @Expose
    private Integer type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LibInfo() {
    }

    /**
     * 
     * @param lastChrCount
     * @param addDate
     * @param type
     */
    public LibInfo(Integer addDate, Integer lastChrCount, Integer type) {
        super();
        this.addDate = addDate;
        this.lastChrCount = lastChrCount;
        this.type = type;
    }

    public Integer getAddDate() {
        return addDate;
    }

    public void setAddDate(Integer addDate) {
        this.addDate = addDate;
    }

    public Integer getLastChrCount() {
        return lastChrCount;
    }

    public void setLastChrCount(Integer lastChrCount) {
        this.lastChrCount = lastChrCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
