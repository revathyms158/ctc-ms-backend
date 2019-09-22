package au.com.optus.ctc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author revathyms
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TrialCondition {

    private String pmp;
    private int age;
    private String postCode;
    private String sex;
    private String nodalStatus;
    private String spreadToOtherParts;
    private String tumourSize;
    private int ecog;
    private String ER;
    private String PR;
    private String HER2;
    private String nodeNumber;
    private int stage;
    private String BRCAMutation;

}
