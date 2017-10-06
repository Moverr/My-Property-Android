package myproperty.codemovers.myproperty.response;

/**
 * Created by Manny on 9/30/2017.
 */

public class PropertySizeResponse {

    private Integer id;
    private String size;
    private String unitMeasure;


    public PropertySizeResponse() {
    }

    public PropertySizeResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertySizeResponse that = (PropertySizeResponse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        return unitMeasure != null ? unitMeasure.equals(that.unitMeasure) : that.unitMeasure == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (unitMeasure != null ? unitMeasure.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  getClass().getCanonicalName()
                +"{" +
                "id=" + id +
                ", size='" + size +"\'"+
                ", unitMeasure='" + unitMeasure +"\'"+
                "}";
    }
}
