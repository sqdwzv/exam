package cn.wangzhen;

import cn.wangzhen.Anno.TargetInterFace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAnno {
    @Autowired
    private TargetInterFace targetInterFace;
    @Test
    public void test(){
        targetInterFace.method();
    }
}
