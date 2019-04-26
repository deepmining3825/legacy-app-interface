package lai.module.starter.sample;

import com.diquest.lai.module.Endpoint;
import com.diquest.lai.module.EndpointMapping;
import lai.module.starter.sample.model.Hello;
import lai.module.starter.sample.model.Time;

import java.util.Date;

@Endpoint
public class SampleEndpoint {

    @EndpointMapping(mapping = "sample.hello", description = "인사메시지 추가")
    public Hello hello(Hello o) {
        o.setMessage("안녕하세요! " + o.getName() + "님");

        return o;
    }

    @EndpointMapping(mapping = "sample.current", description = "현재시간 정보")
    public Time currentTime() {
        return new Time(new Date());
    }

}
