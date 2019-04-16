package cn.webyun.meteorologicalinterface.message.response;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResponseModel {

    private Map resultData;


    public ResponseModel(Map resultData) {
        this.resultData = resultData;
    }


    public void setResultData(HashMap resultData) {
        this.resultData = resultData;
    }

    public Map getResultData() {
        return resultData;
    }
}
