package cn.wangzhen.Anno;

import org.springframework.stereotype.Component;

@Component
public class TargetInterFaceImpl implements TargetInterFace {
    public void method() {
        System.out.println("Target running ...");
        int i=1/0;
    }
}
