package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {

    private String title;
    private int template_id;
    private int type_id;
    private int priority_id;
    private String estimate;
    private int milestone_id;
    private String refs;
    private String mission;
    private String custom_goals;


}
