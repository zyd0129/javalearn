package pattern.proxy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class ServiceImpl implements Service {
    @Override
    public void work() {
        log.info("original service");
    }
}
