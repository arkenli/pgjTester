package io.pgJtester.Execute;

import io.pgJtester.common.Utils;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.Properties;

@Data
public class CustomizedPlan extends Plan{
    int insertCount=0;
    int updateCount=0;
    int selectCount=0;
    int deleteCount=0;
    final String propertyPath="customizedTest.properties";
    public CustomizedPlan(int insertCount, int updateCount, int selectCount, int deleteCount){
    }


    public void init() {

    }

    public void execute() {

    }
    private void loadProperties() throws FileNotFoundException {
        Properties properties= Utils.getProperties(propertyPath);
        this.insertCount=Integer.parseInt(properties.getProperty("insertCount"));
        this.updateCount=Integer.parseInt(properties.getProperty("updateCount"));
        this.selectCount=Integer.parseInt(properties.getProperty("selectCount"));
        this.deleteCount=Integer.parseInt(properties.getProperty("deleteCount"));

    }
}
