package org.example.oom;

import java.util.ArrayList;
import java.util.List;

//shift + command  完成
//-XX:+PrintGCDetails
//-verbose:gc
//-Xloggc:filepath
// -Xloggc:/opt/xxx/logs/xxx-xx-gc-%t.log -XX:+UseGCLogFileRotation --XX:NumberOfGCLogFiles=5
//-XX:GCLogFileSize=20M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCCause

public class HeapOOM {
    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
