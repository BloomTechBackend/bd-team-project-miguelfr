package models.requests;

import java.util.Objects;

public class GetProjectRequest {

    private String id;

    public GetProjectRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
