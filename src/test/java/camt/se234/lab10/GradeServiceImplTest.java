package camt.se234.lab10;

import camt.se234.lab10.service.GradeServiceImpl;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)

public class GradeServiceImplTest {
    public Object paramsForTestGetGradeParams(){
        return new Object[][]{{100,"A"},{77,"B"},{60,"C"},{50,"D"},{10,"F"}};
    }
    public Object paramsForTestGetGrade2TermParams(){
        return new Object[][]{{35,20,"D"},{10,2,"F"},{60,30,"A"},{45,30,"B"},{30,30,"C"}};
    }

    @Test
    @Parameters(method = "paramsForTestGetGradeParams")
    @TestCaseName("Test getGrade Params [{index}] : input is {0}, expect \"{1}\"")
    public void testGetGradeparams(double score,String expectedGrade){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(score),is(expectedGrade));
    }


    @Test
    @Parameters(method = "paramsForTestGetGrade2TermParams")
    @TestCaseName("Test getGrade Params [{index}] : input is {0} and {1} , expect \"{2}\"")
    public void testGet2TermGradeparams(double midterm,double finalTerm,String expectedGrade){
        double score = midterm+finalTerm;
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(score),is(expectedGrade));
    }
}
