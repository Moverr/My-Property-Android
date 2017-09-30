package myproperty.codemovers.myproperty.response;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by mover on 9/30/2017.
 */

public class PropertyResponse {

    private Integer id;
    private Date  dateCreated;
    private Date dateUpdated;
    private String brief;
    private String status;
    private String details;
    private Integer accountId;
    private Integer userId;
    private String property_type;

    private PropertySizeResponse[] propertySizeResponses;

    private String location;
    private String lat;
    private String lng;


    public PropertyResponse() {
    }

    public PropertyResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public PropertySizeResponse[] getPropertySizeResponses() {
        return propertySizeResponses;
    }

    public void setPropertySizeResponses(PropertySizeResponse[] propertySizeResponses) {
        this.propertySizeResponses = propertySizeResponses;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyResponse that = (PropertyResponse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null)
            return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null)
            return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (property_type != null ? !property_type.equals(that.property_type) : that.property_type != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(propertySizeResponses, that.propertySizeResponses)) return false;
        if (location != null ? !location.equals(that.location) : that.location != null)
            return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        return lng != null ? lng.equals(that.lng) : that.lng == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (property_type != null ? property_type.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(propertySizeResponses);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "PropertyResponse{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                ", brief='" + brief + "\'" +
                ", status='" + status + "\'" +
                ", details='" + details + "\' " +
                ", accountId=" + accountId +
                ", userId=" + userId +
                ", property_type='" + property_type + "\'" +
                ", propertySizeResponses=" + Arrays.toString(propertySizeResponses) +
                ", location='" + location + "\'" +
                ", lat='" + lat + "\'" +
                ", lng='" + lng +"'\'" +
                "}";
    }
}
