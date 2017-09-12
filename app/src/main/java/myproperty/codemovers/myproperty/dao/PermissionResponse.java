package myproperty.codemovers.myproperty.dao;

/**
 * Created by Manny on 9/11/2017.
 */

public class PermissionResponse {
    private Integer id;
    private String grouping;
    private String code;
    private String status;
    private String name;

    public PermissionResponse(){
    }

    public PermissionResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName()
                +"{"
                +"id="+id
                +"grouping="+grouping
                +"code="+code
                +"status="+status
                +"name="+name
                +"}";
    }
}
