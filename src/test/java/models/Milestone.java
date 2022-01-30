package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.sql.Array;
import java.sql.Timestamp;

@Data
@Builder
public class Milestone {
    @SerializedName(value = "name")
    private String name;
    private String description;
    private Timestamp due_on;
    private Timestamp start_on;
    private Timestamp started_on;
    private Timestamp completed_on;
    private String url;
    private int parent_id;
    private int id;
    private boolean is_completed;
    private boolean is_started;
    private Array milestones;
    private int project_id;
    private String refs;


}
