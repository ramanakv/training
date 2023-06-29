package jsf.validate;

import javax.faces.context.*;
import javax.faces.component.*;
import javax.faces.validator.*;
import javax.faces.application.*;
import javax.faces.bean.*;

@ManagedBean
public class BidBean {

    private String userID;
    private Double bidAmount;
    private Integer bidDuration;

    public String getUserID() {
        return (userID);
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Double getBidAmount() {
        return (bidAmount);
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getBidDuration() {
        return (bidDuration);
    }

    public void setBidDuration(Integer bidDuration) {
        this.bidDuration = bidDuration;
    }

    public String doBid() {
        doBusinessLogicForValidData();
        return ("show-bid");
    }

    private void doBusinessLogicForValidData() {
    }

   

   
}
