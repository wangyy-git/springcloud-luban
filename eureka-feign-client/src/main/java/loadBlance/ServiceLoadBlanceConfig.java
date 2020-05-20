package loadBlance;

import com.netflix.loadbalancer.IRule;
import com.wangyy.ltd.eurekafeignclient.config.MyIRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLoadBlanceConfig {

    public IRule iRule(){
        return new MyIRule();
    }
}
